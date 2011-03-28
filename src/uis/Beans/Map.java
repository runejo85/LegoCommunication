package uis.Beans;

import java.util.ArrayList;
import java.awt.Color;



public class Map implements IMap {
    private ArrayList<Line> lines = new ArrayList<Line>();
    private static Map instance;

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;

    }


    private Map(){

    }

    public ArrayList<Line> getLines(){
        return lines;
    }

    public void addLine(Line l){
        lines.add(l);

    }

    public void removeLine(Line l){
        lines.remove(l);
    }

    //get a line with start/end point
    public Line getLine(Point start, Point end){
        Line temp = null;

        for(Line l : lines){
            if(l.getStartPoint().equals(start) && l.getEndPoint().equals(end)){
                return l;
            }
        }
        return temp;
    }

    public boolean containsLine(Point start, Point end) {
        return false;
    }

    public boolean setLineColor(Point start, Point end, Color color){
          Line temp = getLine(start, end);
          if(temp != null){
              temp.setLineColor(color);
              return true;
          }
          return false;
    }







}