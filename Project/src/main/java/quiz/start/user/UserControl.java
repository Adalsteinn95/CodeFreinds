package quiz.start.user;


/*
    Aðalsteinn Ingi Pálsson
    aip7@hi.is
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserControl {

    UserCollection data = new UserCollection();

    @RequestMapping("/signup")
    public String signUp(){
        return "user/signup";
    }

    @RequestMapping(value = "/showuser", method = RequestMethod.POST)
    public String showUser(@RequestParam(value = "name")String name,
                           @RequestParam(value = "password")String pass, ModelMap model){
        User u = new User(name,pass);

        //We put user into the collection
        data.addUser(u);


        model.addAttribute("notandi",u);


        return "user/show";
    }

}
