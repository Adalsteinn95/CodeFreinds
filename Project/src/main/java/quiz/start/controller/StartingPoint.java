package quiz.start.controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import quiz.start.model.User;
import quiz.start.repository.UserCollection;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is


/*
handles the user pages
 */


@Controller
public class StartingPoint {



    @RequestMapping(value = {"/","/Question","*","/Question*"})
    public String startReact(){
      return "index";
    }



}
