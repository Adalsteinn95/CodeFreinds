package quiz.start.controller;

import org.springframework.web.bind.annotation.*;
import quiz.start.repository.QuestionCollection;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

/**
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  @date october 2017
 */


/**
 * Controller that manages the question pages
 */
@RestController
public class QuestionControl {

    /**
     * Question data
     */
    private QuestionCollection data;

    /**
     * Question to display on the API
     */
    Hashtable convertedQuestion;

    /**
     * Constructor
     */
    public QuestionControl(){
        this.data = new QuestionCollection("London");

    }


    /**
     * @param answer
     *
     * Updates the API with questions, depending on your previous answer
     * @returns Hashtable
     */
    @RequestMapping(value = "API/question", method = RequestMethod.GET)
    public Hashtable getQuestion1(String answer){

        convertedQuestion = convertQuestion(data);
        return convertedQuestion;
    }

    /**
     * @param location
     *
     * Updates the location that the user picked
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "API/userLocation", method = RequestMethod.POST)
    public void updateLocation(@RequestBody String location) throws UnsupportedEncodingException {
        String result = java.net.URLDecoder.decode(location, "UTF-8");
        String finalCut = result.substring(0, result.length() - 1);

        this.data = new QuestionCollection(finalCut);
    }

    /**
     * @param data
     *
     * Converts questiondata to a hashtable to display on the API
     * @return Hashtable<String, String>
     */
    public Hashtable convertQuestion(final QuestionCollection data) {
        Hashtable<String, String> newQuestion = new Hashtable<String, String>() {{
            put("country1", data.getData().getCountry());
            put("country2", data.getData().getCountry2());
            put("city1", data.getData().getDest1());
            put("city2", data.getData().getDest2());
            put("currentCountry", data.getData().getCurrentCountry());
            put("currentCity", data.getData().getCurrentLoc());
            put("score",data.getData().wasPreviousQuestionCorrect());
            put("correct",data.getData().getCorrectAnswer());
        }};

        return newQuestion;
    }

    /**
     * @param answer
     *
     * Saves submitted answer
     */
    @RequestMapping(value = "API/answer/question", method = RequestMethod.POST )
    public void saveAnswer(@RequestBody String answer) {

        String answers = answer.split(":")[1].split("}")[0];
        String finalAnswer = answers.substring(1,answers.length()-1);
        data.getData().compareDist(finalAnswer);
    }
}
