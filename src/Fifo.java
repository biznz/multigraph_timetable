
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author user
 */
public class Fifo<T> extends MyQueue<T>{
    LinkedList list;
    public Fifo(){
        super();
        this.list = new LinkedList();
        super.type = "fifo";
        super.size = 0;
        super.maxSize = 0;
    }
    
    @Override
    public Fifo add(MyQueue<Vertex> queue, Set<Vertex> vertexes) {
        Fifo fifo = (Fifo)queue;
        if(vertexes==null){return fifo;}
        fifo.list.addAll(vertexes);
        super.size=fifo.list.size();
        if(super.size>super.maxSize){
            super.maxSize=super.size;
        }
        return fifo;
    }
    
    @Override
    public Fifo add(MyQueue<Vertex> queue,Vertex vertex){
        Fifo fifo = (Fifo)queue;
        if(vertex==null){return fifo;}
        fifo.list.add(vertex);
        super.size=fifo.list.size();
        if(super.size>super.maxSize){
            super.maxSize=super.size;
        }
        return fifo;
    }
    
//    @Override
//    public String toString(){
//        System.out.println("printing queue\n");
//        String result ="";
//        for(Object obj:this.list){
//            Vertex vertex = (Vertex)obj;
//            result+= Vertex.result(vertex);
//            result+="\n\n";
//        }
//        return result;
//    }
}
