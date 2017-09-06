package is.hi.byrjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: Aðalsteinn Ingi Pálsson
 * email: aip7@gmail.com
 *
 * Controller that controls the pages for the user
 */

@Controller
@RequestMapping("/demo")
public class DemoController {



     /*
     Shows the user an page with input elements

     returns the page of askUser.jsp
      */
    @RequestMapping("/ask")
    public String askUser(){
        return "demo/askUser";

    }

    /*
    method that gets the value from the input and deliveries it
    to showUser.jsp

    returns the page of showUser.jsp
     */
    @RequestMapping(value="/who", method = RequestMethod.POST)
    public String who(@RequestParam(value="name",required=false)
                      String name, ModelMap model) {
        model.addAttribute("name", name);
        return "demo/showUser";
    }

}
