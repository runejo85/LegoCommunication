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


    protected Map(){

    }

    public ArrayList<Line> getLines(){
        return lines;
    }

    public void addLine(Line l){
        if(!containsLine(l.getStartPoint(), l.getEndPoint())) {
            lines.add(l);
        }

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
            else if (l.getStartPoint().equals(end) && l.getEndPoint().equals(start)) {
                return l;
            }
        }
        return temp;
    }

    public boolean containsLine(Point start, Point end) {
        for(Line l : lines){
            if(l.getStartPoint().equals(start) && l.getEndPoint().equals(end)){
                return true;
            }
            else if (l.getStartPoint().equals(end) && l.getEndPoint().equals(start)) {
                return true;
            }
        }
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
