package quiz.start.controller;
import com.sun.org.apache.regexp.internal.RE;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import quiz.start.model.User;
import quiz.start.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    private String globalErrorMessage = null;

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * shows the home page
     * @return String
     */
    @RequestMapping("")
    public String home() { return ""; }


    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorStatus() {
        return globalErrorMessage;
    }


    /**
     * @param user
     *
     * function to handle user signups
     * @return String
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@Valid @RequestBody User user, BindingResult errors) {

        if (!errors.hasErrors()) {
            if (!userService.validateName(user.getName())) {
                globalErrorMessage = "Notendanafn er tekið";
            }
            else if (!userService.validateEmail(user.getEmail())) {
                globalErrorMessage = "Netfang er í notkun";
            }
            else {
                currentUser = user;
                currentUser.setloginStatus(true);
                currentUser.setPass(passwordEncoder.encode(currentUser.getPass()));
                userService.addUser(user);
                globalErrorMessage = "";
            }
        } else {
            globalErrorMessage = errors.getAllErrors().get(0).getDefaultMessage();
        }
    }


    /**
     * @param user
     *
     * logs in user, will be void or boolean in the future
     * @return String
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user){

        if (userService.userExists(user.getName(), user.getPass())) {
            User tmp = userService.getUser(user.getName());
            tmp.setloginStatus(true);
            userService.update(tmp);
            currentUser = tmp;
            globalErrorMessage = "";
        }

        else {
            globalErrorMessage = "Notendanafn eða lykilorð er rangt";
        }
    }

    /**
     * logs out user
     * @param user
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(@RequestBody User user) {
        user.setloginStatus(false);
        userService.update(user);

        currentUser = new User();
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
     * @return User
     */
    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    public User showCurrentUser() {

        return currentUser;
    }

    @RequestMapping(value = "/updateScore", method = RequestMethod.POST)
    public void updateScore(@RequestBody User user, int newScore) {

        if (newScore > user.getScore()) {
            user.setScore(newScore);
        }
        userService.update(user);
    }

    @RequestMapping(value = "/updateScore", method = RequestMethod.POST)
    public void updateScore(@RequestBody String newScore) {
        int intScore = Integer.parseInt(newScore.substring(0, newScore.length() - 1));

        if (intScore > currentUser.getScore()) {
          currentUser.setScore(intScore);
        }
        userService.update(currentUser);


    }
}
