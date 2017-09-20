package quiz.start.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    shows the sign up page
     */

    @RequestMapping("/signup")
    public String signUp(){
        return "user/signup";
    }

    /*
    handles the sign up 4 user
     */

    @RequestMapping(value = "/showuser", method = RequestMethod.POST)
    public String showUser(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String pass,
                           @RequestParam(value = "email")String email,
                           ModelMap model){
        User u = new User(name,pass,email);

        //We put user into the collection
        data.addUser(u);


        model.addAttribute("user",u);

        return "user/show";
    }

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
