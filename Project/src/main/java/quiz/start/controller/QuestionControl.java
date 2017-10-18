package quiz.start.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import quiz.start.repository.QuestionCollection;
import quiz.start.model.User;

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


@RestController
public class QuestionControl {

    private QuestionCollection data;

    public QuestionControl(){
        this.data = new QuestionCollection("London");
    }


    /*
    * @param String
    *
    *
    * Shows a page with questions, depending on your previous answer
    * @returns String
    */


    @RequestMapping(value = "api/Question", method = RequestMethod.GET)
    public Hashtable getQuestion1(String answer){

        Hashtable convertedQuestion = convertUser(data);

        return convertedQuestion;
    }

    public Hashtable convertUser(final QuestionCollection data) {
        Hashtable<String, String> newQuestion = new Hashtable<String, String>() {{
            put("country1", data.getData().getCountry());
            put("country2", data.getData().getCountry2());
            put("city1", data.getData().getDest1());
            put("city2", data.getData().getDest2());
            put("currentCountry", data.getData().getCurrentCountry());
            put("currentCity", data.getData().getCurrentLoc());
        }};


        return newQuestion;
    }

}
