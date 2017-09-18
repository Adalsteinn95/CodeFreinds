package start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun
 */

@Controller
@RequestMapping("/hello") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir
public class HelloController {


    // Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/page"
    @RequestMapping("/helloworld")
    public String demoPage(){
        return "hello/helloworld";
    }

}
