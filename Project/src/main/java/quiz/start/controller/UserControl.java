package quiz.start.controller;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.start.model.User;
import quiz.start.services.UserService;

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

    private User currentUser = new User();

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
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
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
     * logs in user, will be void or boolean in the future
     * @return String
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String name, String pass){

        if (!userService.userExists(name, pass)) { return "username or password wrong"; }

        User tmp = userService.getUser(name);
        tmp.setloginStatus(true);
        userService.update(tmp);

        currentUser = tmp;

        System.out.println(tmp.getName() + "'s login status is: " + tmp.getLoginStatus());

        return "login successful";
    }

    /**
     * logs out user, will be void in the future
     * @param name
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(String name) {
        User tmp = userService.getUser(name);
        tmp.setloginStatus(false);
        userService.update(tmp);

        currentUser = new User();

        return "logout successful";
    }

    /**
     * @return Arraylist<User>
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
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
    @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
    public User showUser(@PathVariable(value = "userName") String name) {

        User tmp = userService.getUser(name);

        User u = new User(tmp.getName(), tmp.getEmail(), tmp.getPass(), tmp.getLocation(), tmp.getScore(), tmp.getLoginStatus());

        return u;
    }

    /**
     * returns the object for the current user if logged in
     * @param name
     * @return User
     */
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User showCurrentUser(@PathVariable(value = "userName") String name) {

        User tmp = userService.getUser(name);

        if (tmp.getLoginStatus()) {
            currentUser = tmp;
        }

        else {
            return new User();
        }

        currentUser = new User(tmp.getName(), tmp.getEmail(), tmp.getPass(), tmp.getLocation(), tmp.getScore(), tmp.getLoginStatus());

        return currentUser;
    }

    /**
     * function to test the other functions
     * in this class before react is connected
     */
    @RequestMapping(value = "/tests")
    public String routTest() {
        //return login("Geir", "lala");
        //return logout("Geir");
        //return signUp("", "", "", "");
        return "";
    }
}
