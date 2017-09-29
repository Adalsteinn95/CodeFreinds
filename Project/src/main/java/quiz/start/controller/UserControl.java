package quiz.start.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quiz.start.model.User;
import quiz.start.repository.UserCollection;
import quiz.start.repository.SQLUser;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *
 *
 */


/*
handles the user pages
 */


@Controller
@RequestMapping("/user")
public class UserControl {

    UserCollection data = new UserCollection();


    /*
    @param String
    shows the sign up page
    @return String
     */

    @RequestMapping("/signup")
    public String signUp(){
        return "user/signup";
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
    @RequestMapping(value = "/showuser", method = RequestMethod.POST)
    public String showUser(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String pass,
                           @RequestParam(value = "email")String email,
                           ModelMap model){
        User u = new User(name,pass,email);

        //We put user into the collection
        //danna test
        //data.addUser(u);
        try {
            data.deleteUser(u);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("villa í delete user");
        }


        model.addAttribute("user",u);

        return "user/show";
    }

    /*
    @param String

    @return
    */
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLogin(@RequestParam(value = "name")String name,
                            @RequestParam(value = "password")String pass,
                            ModelMap model){
        User u = new User("","","");

        u = data.getUser();

        if(u.getName().equals(name) && u.getPass().equals(pass) ){
            model.addAttribute("user",u);
        }
        System.out.print(name);
        return "user/question";
    }

}
