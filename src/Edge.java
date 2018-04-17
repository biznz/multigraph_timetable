
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
public class Edge {
    private Vertex end1;
    private Vertex end2;
    private Data Flight_info;

    public Edge(Vertex V1, Vertex V2,Data flightInfo){
        this.end1 = V1;
        this.end2 = V2;
        this.Flight_info = flightInfo;
//        for()
//        Flight_info = new Flight_info(num,dep_day,arr_day,days);
        
    }

    @Override
    public String toString() {
        return "Edge{" + "end1: " + end1.toString() + ", end2: " + end2.toString() + ", Flight_info: " + Flight_info.toString() + '}';
    }

    public Vertex getEnd1() {
        return end1;
    }

    public Vertex getEnd2() {
        return end2;
    }

    public Data getFlight_info() {
        return Flight_info;
    }
    
    
    
    
}
