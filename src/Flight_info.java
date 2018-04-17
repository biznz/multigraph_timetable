
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Flight_info extends Data{
    
    private ArrayList<String> days;
    private String Flight_number;
    private LocalTime Arr_Time;
    private LocalTime Dep_Time;
    
    public Flight_info(String input){
        String[] result = input.split("/");
        String number = result[2];
        String Dep_t = result[0];
        String Arr_t = result[1];
        if(Dep_t.length()==4){
            Dep_t = "0"+Dep_t;
        }
        if(Arr_t.length()==4){
            Arr_t = "0"+Arr_t;
        }
//        System.out.println("printing arr_t "+Arr_t);
//        System.out.println("printing dep_t "+Dep_t);
//        System.out.println("----------");
        String input_days;
        days = new ArrayList<String>();
        if(!result[3].equals("alldays")){
            input_days = result[3].substring(1, result[3].length()-1);
        }
        else
        {
            input_days = result[3];
        }
        
        try{
            Arr_Time = LocalTime.parse(Arr_t);
            Dep_Time = LocalTime.parse(Dep_t);
//            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
//            Arr_Time = df.parse(Arr_t);
//            Dep_Time = df.parse(Dep_t);
//            System.out.println(Arr_Time.toString()+"-----");
//            System.out.println(Dep_Time.toString()+"-----");
            }
        catch(DateTimeParseException ex){ 
            System.out.println("could not parse time");
        }
        this.Flight_number = number;
        String [] list = input_days.split(",");
        for(String s:list){
//            System.out.println(s);
            this.days.add(s);
        }
    }
            //ArrayList<String>();

    public ArrayList<String> getDays() {
        return days;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight_info other = (Flight_info) obj;
        if (!Objects.equals(this.Flight_number, other.Flight_number)) {
            return false;
        }
        if (!Objects.equals(this.days, other.days)) {
            return false;
        }
        if (!Objects.equals(this.Arr_Time, other.Arr_Time)) {
            return false;
        }
        if (!Objects.equals(this.Dep_Time, other.Dep_Time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String days ="";
        for(String s: this.days){
            days+=" "+s;
        }
        return "\nFlight_info{" + "days: " + days + ", Flight_number: " + Flight_number + ", Arr_Time: " + Arr_Time.toString() + ", Dep_Time: " + Dep_Time.toString() + '}';
    }

    
    
}
