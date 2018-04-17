
import java.util.EmptyStackException;
import java.util.HashSet;
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
    
    
    protected static String BFS(Place origin,Place destination, MultiGraph graph){
        MyQueue<Vertex> vertexes = MAKE_QUEUE(origin);
        Set<Vertex> explored = new HashSet<Vertex>();
        while(!EMPTY(vertexes)){
            Vertex vertex = REMOVE_FRONT(vertexes);
            explored.add(vertex);
            //if()
            for(Edge e:graph.getEdges(vertex.getPlace())){
                if(!explored.contains(e.getEnd2())){
                    if (vertex.getPlace().equals(destination)){
                        return " result";
                    }
                    vertexes.add(vertexes, e.getEnd2());
                }
            }
        }
        return "solution not found";
    }
    
    
    protected static MyQueue<Vertex> MAKE_QUEUE(Place origin){
        MyQueue<Vertex> queue = new Lifo();
        queue.add(queue, new Vertex(origin));
        return queue;
    }
    
    
    
    protected static boolean EMPTY(MyQueue<Vertex> queue){
        if(queue.size==0)return true;
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
