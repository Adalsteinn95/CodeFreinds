package quiz.start.question;


/*
 *
 *
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import quiz.start.user.UserCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

@Controller
@RequestMapping("/question")
public class QuestionControl {

    /*
    *
    * API CALL
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
