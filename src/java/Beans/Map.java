package java.Beans;

import java.util.ArrayList;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 14.03.11
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class Map {
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

    public boolean setLineColor(Point start, Point end, Color color){
          Line temp = getLine(start, end);
          if(temp != null){
              temp.setLineColor(color);
              return true;
          }
          return false;
    }







}
