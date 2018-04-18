
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
    
    //protected static DFSHelper(Vertex vertex,HashSet<Vertex>)
    protected static int INFINITY = Integer.MAX_VALUE;
    
//    protected static Djisktra(MultiGraph graph, Place origin,Place destination){
//        HashSet<Vertex> Q;
//        HashSet<Vertex>
//        for(Vertex v: graph.V){
//            
//        }
//        
//        while( !Q.isEmpty()){
//            //Vertex u = 
//            for(Edge e:graph.getEdges(vertex.getPlace())){
//                
//            }
//        }
//    }
    
      
//    public static void DFS(Place place,Place destination,HashSet<Vertex> visited,MultiGraph graph,String day){
//        if(place.equals(destination)){
//            return
//        }
//        for(Edge e:graph.getEdges(place)){
//            if(!visited.contains(e.getEnd2()) && checksConstraint(day,e)){
//                visited.add(new Vertex(place));
//                DFSHelper(e.getEnd2().getPlace(),visited,graph,day);
//            }
//        }
//        for(Vertex v:visited){
//            System.out.println(v+ "-->");
//        }
//    }
//    public static void DFSHelper(Place origin,Place destination,MultiGraph graph,String day){
//        HashSet<Vertex> vertexes = new HashSet<Vertex>();
//        DFSHelper(origin,destination,graph,day);
//    }
    
    protected static HashSet<Vertex> DFS(Place origin,Place destination, MultiGraph graph,String day){
        MyQueue<Vertex> vertexes = MAKE_QUEUE(origin);
        HashSet<Vertex> explored = new HashSet<Vertex>();
        LinkedList<Edge> flight_plan = new LinkedList<Edge>();
        while(!EMPTY(vertexes)){
            Vertex vertex = REMOVE_FRONT(vertexes);
            explored.add(vertex);
            System.out.println("removed "+vertex.getPlace().getName());
            for(Edge e:graph.getEdges(vertex.getPlace())){
                if(!explored.contains(e.getEnd2()) && checksConstraint(day,e)){
                    //System.out.println("Not previously explored "+e.getEnd2().toString());
                    if (e.getEnd2().getPlace().equals(destination)){
                        ///flight_plan.add(e);
                        explored.add(e.getEnd2());
                        return explored;
                    }
                    vertexes.add(vertexes, e.getEnd2());
                    //flight_plan.add(e);
                }
            }
//            if(graph.getEdges(vertex.getPlace()).isEmpty() && !vertex.getPlace().equals((destination))){
//                explored.remove(vertex);
//            }
            //explored.remove(vertex);
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
        MyQueue<Vertex> queue = new Fifo();
        queue.add(queue, new Vertex(origin));
        return queue;
    }
    
    
    
    protected static boolean EMPTY(MyQueue<Vertex> queue){
        if(((Fifo)queue).list.isEmpty())return true;
        return false;
    }
    
    public static Vertex REMOVE_FRONT(MyQueue<Vertex> vertexes){
        Fifo fifo = (Fifo) vertexes;
        Vertex result;
        try{
            result = (Vertex) fifo.list.remove();
        }
        catch(EmptyStackException ex){
            return null;
        }
        return result;
        
    }
}
