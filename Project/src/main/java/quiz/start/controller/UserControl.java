package quiz.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.
import quiz.start.model.User;
import quiz.start.repository.UserCollection;
import quiz.start.repository.UserRepository;
import quiz.start.services.UserService;

import java.sql.SQLException;
import java.util.List;

<<<<<<< HEAD
/**
 * @author Aðalsteinn Ingi Pálsson - aip7@hi.is
 *                    Geir Garðarsson - geg42@hi.is
 *                    Fannar Gauti Guðmundsson - fgg2@hi.is
 *                    Daníel Guðnason - dag27@hi.is

=======
/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 *  Fannar Gauti Guðmundsson
 *  fgg2@hi.is
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.
 *
 */


/*
handles the user pages
 */


@RestController
@RequestMapping("/user")
public class UserControl {

    private UserCollection data = new UserCollection();
    private QuestionControl q;

    public UserControl() throws SQLException {}

    @Autowired
    UserService userService;


    User test = new User(0,"Kalli","1234",false,"kalli","Djamm", 9);


    /*
     @param String
     shows the home page
     @return String
     */
    @RequestMapping("")
    public String home() { return "user/home"; }


    /*
    @param String
    shows the sign up page
    @return String
     */
    @RequestMapping("/signup")
    public String signUp() { return "user/signup"; }

    /*
    @param String
    @param String
    @param String
    @param ModelMap
      handles the sign up for the user
      and shows confirmation
    @return String
     */
    /*
    @RequestMapping(value = "/showuser", method = RequestMethod.POST)
    public String showUser(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String pass,
                           @RequestParam(value = "email")String email,
                           ModelMap model) throws ClassNotFoundException, SQLException {
        User u = new User(id, name,pass,email, 0, "Reykjavik");

        //Validate username
        if (data.validateUser(u.getName())) {

            //We put user into the collection
            data.addUser(u);

        } else {
            System.out.println("Username taken");
            return "/user/signup";
        }

        model.addAttribute("user",u);

        return "user/show";
    }*/

    /*
     * Shows a login page
     * @return String
     */
    @RequestMapping("/login")
<<<<<<< HEAD
    public String login(String name, String pass){

        if (!userService.userExists(name, pass)) { return "username or password wrong"; }
=======
    public String login(){
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.

        //System.out.println(userService.getAllUsers().size());

        userService.addUser(test);

        return Integer.toString(userService.getAllUsers().size());
    }


    /*
     * @param String
     * @param String
     * @param ModelMap
     * Shows a user profile page for successful logins
     *
     * @return String
     *//*
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String showLogin(@RequestParam(value = "name")String name,
                            @RequestParam(value = "password")String pass,
                            ModelMap model){

        try {
            data.loginUser(name, pass);
            User u = data.getCurrent_user();
            model.addAttribute("user",u);
        }
        catch (Exception e) {
            return error();
        }

        return "user/profile";
    }*/


    /*
     * Shows a loginerror page
     * @return String
     */
    @RequestMapping(value = "/error")
    public String error() { return "error/login_error"; }

<<<<<<< HEAD
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
=======
>>>>>>> parent of 3b61c60... JPA connection og base fyrir API komid.
}
