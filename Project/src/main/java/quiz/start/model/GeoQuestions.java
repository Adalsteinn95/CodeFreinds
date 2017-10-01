package quiz.start.model;

import quiz.start.services.GeoService;

import java.util.Random;

public class GeoQuestions extends Question{

    private String[] cities;
    private String currentLoc;

    /* dest 1 and dest 2*/
    private String dest1;
    private String dest2;

    /* distance between currentLoc && dest1 ||
     * currentloc && dest2
     */
    private double distance1;
    private double distance2;

    private Random r;


    /*API*/
    GeoService api;

    public GeoQuestions(String location){
        super();

        cities = new String[11];

        cities[0] = "New York";
        cities[1] = "Reykjavik";
        cities[2] = "Berlin";
        cities[3] = "Paris";
        cities[4] = "Amsterdam";
        cities[5] = "Los Angeles";
        cities[6] = "Tokyo";
        cities[7] = "Bejing";
        cities[8] = "Chicago";
        cities[9] = "Liverpool";
        cities[10] = "Moscow";

        currentLoc = location;

        /*Random generator*/
        r = new Random();

        /*this will get a random value from cities*/
        dest1 = cities[r.nextInt(cities.length)];
        dest2 = cities[r.nextInt(cities.length)];


        api = new GeoService();

    }


    public void compareDist(String answer){

        distance1 = api.getDist(currentLoc,dest1);
        distance2 = api.getDist(currentLoc,dest2);

        if(answer.equals(dest1)){
           if(distance2 >= distance1){
               currentLoc = dest1;
           }
        }

        if(answer.equals(dest2)){
            if(distance1 >= distance2){
                currentLoc = dest2;
            }
        }

        dest1 = cities[r.nextInt(cities.length)];
        dest2 = cities[r.nextInt(cities.length)];

    }

    public String getDest1() {
        return dest1;
    }

    public String getDest2() {
        return dest2;
    }

    public String getCurrentLoc(){
        return currentLoc;
    }

}
