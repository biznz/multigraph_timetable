
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Program {
    
    static String[] places = {"london","zurich","ljubliana","milan","edinburgh"};
    static String[] timeTable1 = {"edinburgh","london","9:40/10:50/ba4733/alldays","13:40/14:50/ba4773/alldays","19:40/20:50/ba4833/[mo,tu,we,th,fr,su]"};
    static String[] timeTable2 = {"london","edinburgh","9:40/10:50/ba4732/alldays","11:40/12:50/ba4752/alldays","18:40/19:50/ba4822/[mo,tu,we,th,fr]"};
    static String[] timeTable3 = {"london","ljubljana","13:20/16:20/ju201/[fr]","13:20/16:20/ju213/[su]"};
    static String[] timeTable4 = {"london","milan","8:30/11:20/ba510/alldays","11:00/13:50/az459/alldays"};
    static String[] timeTable5 = {"ljubljana","london","11:10/12:20/yu200/[fr]","11:25/12:20/yu212/[su]"};
    static String[] timeTable6 = {"ljubljana","zurich","11:30/12:40/ju322/[tu,th]"};
    static String[] timeTable7 = {"milan","london","9:10/10:00/az458/alldays","12:20/13:10/ba511/alldays"};
    static String[] timeTable8 = {"milan","zurich","9:25/10:15/sr621/alldays","12:45/13:35/sr623/alldays"};
    static String[] timeTable9 = {"zurich","ljubljana","13:30/14:40/yu323/[tu,th]"};
    static String[] timeTable10 = {"zurich","london","9:00/9:40/ba613/[mo,tu,we,th,fr,sa]","16:10/16:55/sr806/[mo,tu,we,th,fr,su]"};
    static String[] timeTable11 = {"zurich","milan","7:55/8:45/sr620/alldays"};
    
    static ArrayList<String[]> database = new ArrayList<String[]>();
    static MultiGraph airports;
//    static String[] timeTable5 = {"edinburgh","london","9:40/10:50/ba4733/alldays","13:40/14:50/ba4773/alldays","19:40/20:50/ba4833/[mo,tu,we,th,fr,su]"};
    
    public static void main(String[] args){
        airports = new MultiGraph();
        buildDatabase();
        for(String[] item: database){
            Vertex depart = new Vertex(new Place(item[0]));
            Vertex destin = new Vertex(new Place(item[1]));
            for(int i=0;i<(item.length-2);i++){
                Flight_info flight = new Flight_info(item[2+i]);
                Edge edge = new Edge(depart,destin,flight);
                airports.addEdge(edge);
            }
            if(!airports.V.contains(depart)){
                airports.addVertex(depart);
            }
            if(!airports.V.contains(destin)){
                airports.addVertex(destin);
            }
            
        }
        //airports.printVertex();
        //airports.printEdges();
        // reply to first question
        //System.out.println("Days of the week there is a direct flight from london to milan");
        //System.out.println(daysOfTheWeekDirectFlight(new Place("zurich"),new Place("ljubljana")));
        //available flights between Place1 and Place2 on day X
        System.out.println(Search.DFS(new Place("london"),new Place("zurich"),airports,"th"));
    }
    
    public static void buildDatabase(){
        database.add(timeTable1);
        database.add(timeTable2);
        database.add(timeTable3);
        database.add(timeTable4);
        database.add(timeTable5);
        database.add(timeTable6);
        database.add(timeTable7);
        database.add(timeTable8);
        database.add(timeTable9);
        database.add(timeTable10);
        database.add(timeTable11);
    }
    
    public static String daysOfTheWeekDirectFlight(Place place1,Place place2){
        ArrayList<Edge> flights = airports.getEdges(place1, place2);
        String result="";
        ArrayList<String> r = getDays(flights);
        for(String s:r){
            result+=" "+s;
        }
        return result;
    }
    
    public static ArrayList<String> getDays(ArrayList<Edge> Edges){
        ArrayList<String> days = new ArrayList<String>();
        for(Edge e: Edges){
            Flight_info info = (Flight_info)e.getFlight_info();
            for(String s:info.getDays()){
                //System.out.println(" ---- "+s);
                if(s.equals("alldays")){days = new ArrayList<String>();days.add(s);return days;};
                if(!days.contains(s)){
                    days.add(s);
                }
            }
        }
        return days;
    }
}
