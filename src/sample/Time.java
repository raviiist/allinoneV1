package sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;


public class Time implements Comparator<Time>{
    Calendar t = Calendar.getInstance();
    SimpleDateFormat sdfI6 = new SimpleDateFormat("yyyy DDD HH mm ss SSS");
    SimpleDateFormat sdfCalendar = new SimpleDateFormat("yyyy MM dd HH mm ss SSS");

    public Time(){}

    public Time(String sI6,SimpleDateFormat sdf){
        try{
            t.setTime(sdf.parse(sI6));
        }catch (Exception e) {
            System.out.println("Time format entered is not correct Exiting");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Time(String sI6){
        try{
            t.setTime(sdfI6.parse(sI6));
        }catch (Exception e) {
            System.out.println("Time format entered is not correct Exiting");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public Time(Time in){
        t.setTimeInMillis(in.getTimeInMillis());
    }

    public Time(Calendar in){
        t.setTimeInMillis(in.getTimeInMillis());
    }

    public Time(long time){
        t.setTimeInMillis(time);
    }

    public void calStr2Time(String sI7){
        try{
            t.setTime(sdfCalendar.parse(sI7));
        }catch (Exception e) {
            System.out.println("Time format entered is not correct Exiting");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public long getTimeInMillis(){
        return t.getTimeInMillis();
    }

    public void setTimeInMillis(long millis){
        t.setTimeInMillis(millis);
    }

    public String toString(){
        //System.out.println("Calender format:"+t.getTime());
        return sdfI6.format(t.getTime());
    }

    public String getString(SimpleDateFormat sdf){
        return sdf.format(t.getTime());
    }

    public void set(int i,int j){
        t.set(i, j);
    }

    public int get(int i){
        return t.get(i);
    }

    public void set(int year,int  month,int  date,int  hourOfDay,int  minute,int  second){
        t.set(year, month, date, hourOfDay, minute, second);
    }

    public void changeTimeByDelta(long millis){
        //return t.getTimeInMillis(t.setTimeInMillis(t.getTimeInMillis() + millis));
        t.setTimeInMillis(t.getTimeInMillis() + millis);
    }

    public int compareTo(Time t2) {
        return t.compareTo(t2.t);
    }

    public int compare(Time arg0, Time arg1) {
        if(arg0.getTimeInMillis() > arg1.getTimeInMillis())
            return -1;
        else if(arg0.getTimeInMillis() == arg1.getTimeInMillis())
            return 0;
        else
            return 1;
    }
}