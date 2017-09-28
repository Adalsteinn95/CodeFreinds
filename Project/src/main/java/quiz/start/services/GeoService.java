package quiz.start.services;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 */


/*
Controller that manages the question pages
*/
@RestController
public class GeoService {

    private RestTemplate restTemplate;
    private Hashtable hash;


    /*distance*/
    private int distance;

    /*place a and b */
    private String locationA;
    private String locationB;


    public GeoService(){
        restTemplate = new RestTemplate();

    }


    /*
     * @param String
     * @param String
     *
     * function that takes a name of place a and place b and returns info about them
     * distance between them and more
     *
     * @Return Hashtable
     *
     */
    public Hashtable apiCallBetweenTwoPlaces(){

        hash = restTemplate.getForObject("http://www.distance24.org/route.json?stops=" + locationA + "|" + locationB, Hashtable.class);


        Enumeration names;
        String key;
        names = hash.keys();
        while(names.hasMoreElements()) {
            key = (String) names.nextElement();

            if(key.equals("distance")){
                distance = Integer.parseInt(hash.get(key).toString());
            }

            System.out.println("Key: " +key+ " & Value: " +
                    hash.get(key).getClass());
        }


        return hash;
    }


    public int getDist(String a, String b){
        locationA = a;
        locationB = b;

        apiCallBetweenTwoPlaces();

        return distance;
    }



    /*
     * @param double
     * @param double
     *
     *
     *
     * @return Hashtable
     *
     */

    @RequestMapping("/location/google")
    public Hashtable googleAPI(double lat, double lng){

        String latString = String.valueOf(lat);
        String lngString = String.valueOf(lng);

        Hashtable hash = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latString + "," + lngString + "&key=AIzaSyCkXt5PmbfwdeWqJFqAHt4bnKqRkHcfEwo",Hashtable.class);

        return hash;
    }


}
