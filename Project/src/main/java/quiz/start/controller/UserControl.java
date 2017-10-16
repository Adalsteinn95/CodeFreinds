package quiz.start.controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quiz.start.model.User;
import quiz.start.repository.UserCollection;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 *  Fannar Gauti Guðmundsson
 *  fgg2@hi.is
 *
 */


/*
handles the user pages
 */


@RestController
public class UserControl {

    private UserCollection data = new UserCollection();
    private QuestionControl q;


    public UserControl() throws SQLException {

    }

    /*
    @param String
    @param String
    @param String
    @param ModelMap
      handles the sign up for the user
      and shows confirmation
    @return String
     */
    @RequestMapping(value = "/showuser", method = RequestMethod.GET)
    public Hashtable signUp(String name, String pass, String email) throws ClassNotFoundException, SQLException {


        User u = new User(name,pass,email, 0, 0, "Reykjavik", false);

        Hashtable convertedUser = convertUser(u);


        //Validate username
        if (data.validateUser(u.getName())) {

            //We put user into the collection
            data.addUser(u);

        } else {
            System.out.println("Username taken");
            return null;
        }


        return convertedUser;
    }

    /*convert user to hashtable*/
    public Hashtable convertUser(final User u){
        Hashtable<String,String> newUser = new Hashtable<String,String>(){{
           put("name", u.getName());
           put("pass", u.getPass());
           put("email", u.getEmail());
           put("location", u.getLocation());
           put("Highscore", Integer.toString(u.getHighScore()));
           put("score", Integer.toString(u.getScore()));
        }};

        return newUser;
    }

    /*
     * @param String
     * @param String
     * @param ModelMap
     * Shows a user profile page for successful logins
     *
     * @return String
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showLogin(@RequestParam(value = "name")String name,
                            @RequestParam(value = "password")String pass,
                            ModelMap model){

        try {
            data.loginUser(name, pass);
            User u = data.getCurrent_user();
            model.addAttribute("user",u);
        }
        catch (Exception e) {

        }

        return "user/profile";
    }



}
