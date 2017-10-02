package quiz.start.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import quiz.start.repository.QuestionCollection;

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

    QuestionCollection data;

    public QuestionControl(){

        data = new QuestionCollection("London");
    }

    @RequestMapping("/location")
    public String getLocation(ModelMap model){

        model.addAttribute("Question",data);

        return "question/location";

    }

    @RequestMapping(value = "/questionLocation", method = RequestMethod.POST)
    public String getQuestion1(@RequestParam(value = "answer1")String answer, ModelMap model){

        data.getData().compareDist(answer);

        model.addAttribute("Question",data);

        return "question/location";
    }

    @RequestMapping(value = "/questionLocation2", method = RequestMethod.POST)
    public String getQuestion2(@RequestParam(value = "answer2")String answer, ModelMap model){

        data.getData().compareDist(answer);

        model.addAttribute("Question",data);

        return "question/location";
    }


}
