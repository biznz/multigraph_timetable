
import java.util.ArrayList;
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
public class MultiGraph {
    
    public Set<Edge> E;
    public Set<Vertex> V;
    
    public MultiGraph(){
        this.E = new HashSet<Edge>();
        this.V = new HashSet<Vertex>();
    }
    public MultiGraph(HashSet<Edge> E,HashSet<Vertex> V){
        this.E = E;
        this.V = V;
    }
    
    public void addEdge(Edge E){
        this.E.add(E);
    }
    
    public void addVertex(Vertex V){
        this.V.add(V);
    }
    
    public int size(){
        return this.E.size();
    }
    
    public int order(){
        return this.V.size();
    }
    
    
    public ArrayList<Edge> getEdges(Place origin){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        System.out.println(origin.getName());
        for(Edge e:this.E){
            if(e.getEnd1().getPlace().equals(origin)){
                edges.add(e);
            }
        }
        return edges;
    }
    
    public ArrayList<Edge> getEdges(Place dep,Place dest){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        int size=0;
        for(Edge e:this.E){
            if(e.getEnd1().getPlace().equals(dep) && e.getEnd2().getPlace().equals(dest)){
                edges.add(e);
            }
        }
        return edges;
    }
    
    public void printEdges(){
        for(Edge e: E){
            System.out.println("\n"+e);
        }
    }
    
    public void printVertex(){
        for(Vertex v: V){
            System.out.println("\n"+v);
        }
    }
}
