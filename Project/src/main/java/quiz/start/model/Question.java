package quiz.start.model;

/*
Aðalsteinn Ingi Pálsson
aip7@hi.is
*/

import org.mockito.Answers;

public class Question {

    private String subject;
    private String category;


    public Question(){
    }

    public String getSubject(){
        return this.subject;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String cat){
        this.category = cat;
    }

    public void setSubject(String sub){
        this.subject = sub;
    }
}
