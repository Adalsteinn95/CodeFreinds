package quiz.start.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quiz.start.model.User;
import quiz.start.repository.UserCollection;
import quiz.start.repository.SQLUser;

import java.sql.SQLException;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 *  Fannar Gauti Guðmundsson
 *  *@hi.is
 *
 */


/*
handles the user pages
 */


@Controller
@RequestMapping("/user")
public class UserControl {

    UserCollection data = new UserCollection();

    public UserControl() throws SQLException {
    }

    /*
     @param String
     shows the home page
     @return String
     */
    @RequestMapping("/")
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
    @RequestMapping(value = "/showuser", method = RequestMethod.POST)
    public String showUser(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String pass,
                           @RequestParam(value = "email")String email,
                           ModelMap model) throws ClassNotFoundException, SQLException {
        User u = new User(name,pass,email, 0, 0, "", false);

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
    }

    /*
     * Shows a login page
     * @return String
     */
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }


    /*
     * @param String
     * @param String
     * @param ModelMap
     * Shows a user profile page for successful logins
     *
     * @return String
     */
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String showLogin(@RequestParam(value = "name")String name,
                            @RequestParam(value = "password")String pass,
                            ModelMap model){
        User u = new User("","","", 0, 0, "", false);

        try {
            u = data.getUser(name, pass);
            model.addAttribute("user",u);
        }
        catch (Exception e) {
            return error();
        }

        return "user/profile";
    }


    /*
     * Shows a loginerror page
     * @return String
     */
    @RequestMapping(value = "/error")
    public String error() { return "error/login_error"; }

}
