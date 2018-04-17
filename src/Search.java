
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Search {
    
    
    //need to change this to an IDFS
    // must remove non valid edges, flights from flight plan
    protected static LinkedList<Edge> BFS(Place origin,Place destination, MultiGraph graph,String day){
        MyQueue<Vertex> vertexes = MAKE_QUEUE(origin);
        Set<Vertex> explored = new HashSet<Vertex>();
        LinkedList<Edge> flight_plan = new LinkedList<Edge>();
        while(!EMPTY(vertexes)){
            Vertex vertex = REMOVE_FRONT(vertexes);
            explored.add(vertex);
            //System.out.println("removed "+vertex.getPlace().getName());
            for(Edge e:graph.getEdges(vertex.getPlace())){
                if(!explored.contains(e.getEnd2()) && checksConstraint(day,e)){
                    //System.out.println("Not previously explored "+e.getEnd2().toString());
                    if (e.getEnd2().getPlace().equals(destination)){
                        flight_plan.add(e);
                        return flight_plan;
                    }
                    vertexes.add(vertexes, e.getEnd2());
                    flight_plan.add(e);
                }
            }
        }
        return null;
    }
    
    public static boolean checksConstraint(String test, Edge e){
        Flight_info info = (Flight_info)e.getFlight_info(); 
        for(String day:info.getDays()){
            if(test.equals(day) || day.equals("alldays")){
                return true;
            }
        }
        return false;
    }
    
    protected static MyQueue<Vertex> MAKE_QUEUE(Place origin){
        MyQueue<Vertex> queue = new Lifo();
        queue.add(queue, new Vertex(origin));
        return queue;
    }
    
    
    
    protected static boolean EMPTY(MyQueue<Vertex> queue){
        if(((Lifo)queue).list.empty())return true;
        return false;
    }
    
    public static Vertex REMOVE_FRONT(MyQueue<Vertex> vertexes){
        Lifo lifo = (Lifo) vertexes;
        Vertex result;
        try{
            result = (Vertex) lifo.list.pop();
        }
        catch(EmptyStackException ex){
            return null;
        }
        return result;
        
    }
}
