package quiz.start.repository;

/**
 *Aðalsteinn Ingi Pálsson
 *aip7@hi.is
 */

import quiz.start.model.GeoQuestions;

/**
 * Middleclass between the model and the third party libraries
 */
public class QuestionCollection {

    private GeoQuestions geoQuestions;

    public QuestionCollection(String location){
        geoQuestions = new GeoQuestions(location);
    }

    public GeoQuestions getData() {
        return geoQuestions;
    }
}
