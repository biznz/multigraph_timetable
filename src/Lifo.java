
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author user
 */
public class Lifo<T> extends MyQueue<T>{
    
    /** TODO **
    Confirm if I should be using a stack or dequeue
    need to remove element from the front of a list
    fifo vs lifo
    **/
    Stack list; 

    public Lifo(){
        super();
        list = new Stack<>();
        super.type = "lifo";
        super.size = 0;
        super.maxSize = 0;
    }
    @Override
    public Lifo add(MyQueue<Vertex> queue, Set<Vertex> vertexs) {
        Lifo lifo = (Lifo)queue;
        if(vertexs==null){return lifo;}
        for(Vertex n: vertexs){
            lifo.list.push(n);
            super.size+=1;
            if(super.size>super.maxSize){
                super.maxSize = super.size;
            }
        }
        return lifo;
    }

    @Override
    public Lifo add(MyQueue<Vertex> queue,Vertex vertex){
        Lifo lifo = (Lifo) queue;
        if(vertex==null){return lifo;}
        lifo.list.push(vertex);
        super.size+=1;
        if(super.size>super.maxSize){
            super.maxSize=super.size;
        }
        return lifo;
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
    //method builds resulting path from search algorithm output
    public Lifo build(Vertex current){
        if(current!=null){
            this.list.push(current);
            super.size+=1;
            if(super.size>super.maxSize){
                super.maxSize=super.size;
            }
            //return build(current.getPARENT_NODE());
        }
        return this;
    }
    
//    public String pathPrint(){
//        String result = "";
//        while(this.list.size()!=0){
//            Vertex vertex =(Vertex)this.list.pop();
//            if(vertex.OPERATOR!=null){
//                result+="move to: ";
//                result+=vertex.printMovement()+"\n\n";
//            }
//            else{
//                result+="Printing movements made \n\n";
//            }
//            //result+=Vertex.result(vertex)+"\n";
//        }
//        return result;
//    }
}
