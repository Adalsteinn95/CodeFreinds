package quiz.start.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Hashtable;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 */


/*
Controller that manages the question pages
*/
@Controller
@RequestMapping("/question")
public class QuestionControl {

    /*
    * API CALL NOT READY
     */

    @RequestMapping("/location")
    public String apiCall(){
        RestTemplate restTemplate = new RestTemplate();
        Hashtable hash = restTemplate.getForObject("http://www.distance24.org/route.json?stops=Newyork|London", Hashtable.class);

        Collection a = hash.values();
        String b = hash.toString();
        System.out.print(b);

        return "question/location";
    }

}
