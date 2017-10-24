package quiz.start.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quiz.start.model.User;
import quiz.start.user.UserService;

import java.util.ArrayList;

/**
 * @author Aðalsteinn Ingi Pálsson - aip7@hi.is
 *                    Geir Garðarsson - geg42@hi.is
 *                    Fannar Gauti Guðmundsson - fgg2@hi.is
 *                    Daníel Guðnason - dag27@hi.is

 *
 * Control class for user functions
 * @date october 2017
 */

@RestController
@RequestMapping("/API")
public class UserControl {

	public UserControl() {}

	@Autowired
	UserService userService;

	/**
	 * shows the home page
	 * @return String
	 */
	@RequestMapping("")
	public String home() { return "user/home"; }


	/**
	 * @param name
	 * @param email
	 * @param pass
	 * @param location
	 *
	 * function to handle user signups
	 * @return String
	 */
	@RequestMapping("/signup")
	public String signUp(String name, String email, String pass, String location) {

		if (!userService.validateName(name)) { return "username taken"; }

		User u = new User(name, email, pass, location, 0, false);

		userService.addUser(u);

		return "signup successful";
	}


	/**
	 * @param name
	 * @param pass
	 *
	 * Shows a login page
	 * @return String
	 */
	@RequestMapping("/login")
	public String login(String name, String pass){

		if (!userService.userExists(name, pass)) { return "username or password wrong"; }

		User tmp = userService.getUser(name);
		tmp.setloginStatus(true);

		System.out.println(tmp.getName() + "'s login status is: " + tmp.getLoginStatus());

		return "login successful";
	}

	/**
	 * @return Arraylist<User>
	 */
	@RequestMapping("/users")
	public ArrayList<User> showUsers() {

		ArrayList<User> tmp = (ArrayList<User>) userService.getAllUsers();

		return tmp;
	}

	/**
	 * @param name
	 *
	 * displays User object as json
	 * @return
	 */
	@RequestMapping(value = "/users/{user_name}")
	public User showUser(@PathVariable(value = "user_name") String name) {

		User tmp = userService.getUser(name);

		User u = new User(tmp.getName(), tmp.getEmail(), tmp.getPass(), tmp.getLocation(), tmp.getScore(), tmp.getLoginStatus());

		return u;
	}

	/**
	 * function to test the other functions
	 * in this class before react is connected
	 */
	@RequestMapping(value = "/tests")
	public String routTest() {
		return login("Harrison Ford", "lala");
		//return signUp("Harrison Ford", "hf@hollywood", "lala", "California");
	}
}
