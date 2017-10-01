package quiz.start.repository;

/*
Aðalsteinn Ingi Pálsson
aip7@hi.is
*/

import quiz.start.model.GeoQuestions;

import java.util.ArrayList;

public class QuestionCollection {

    private GeoQuestions geoQuestions;

    public QuestionCollection(String location){
        geoQuestions = new GeoQuestions(location);
    }


    public GeoQuestions getData() {
        return geoQuestions;
    }
}
