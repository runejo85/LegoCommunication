package uis.Beans;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/23/11
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.awt.Color;



public class FMap implements IMap {
    private ArrayList<Line> lines = new ArrayList<Line>();
    private static FMap instance;

    public static FMap getInstance() {
        if (instance == null) {
            instance = new FMap();
        }
        return instance;

    }


    private FMap(){
        addLine(new Line(new Point(0,0), new Point(1,0), Color.black));
        addLine(new Line(new Point(0,0), new Point(0,1), Color.black));

        addLine(new Line(new Point(1,0), new Point(1,1), Color.black));
        addLine(new Line(new Point(1,0), new Point(2,0), Color.black));

        addLine(new Line(new Point(2,0), new Point(2,1), Color.black));

        addLine(new Line(new Point(0,1), new Point(1,1), Color.black));
        addLine(new Line(new Point(0,1), new Point(0,2), Color.black));

        addLine(new Line(new Point(1,1), new Point(1,2), Color.black));
        addLine(new Line(new Point(1,1), new Point(2,1), Color.black));

        addLine(new Line(new Point(2,1), new Point(2,2), Color.black));

        addLine(new Line(new Point(0,2), new Point(1,2), Color.black));
        addLine(new Line(new Point(0,2), new Point(0,3), Color.black));

        addLine(new Line(new Point(1,2), new Point(2,2), Color.black));
        addLine(new Line(new Point(1,2), new Point(1,3), Color.black));

        addLine(new Line(new Point(2,2), new Point(2,3), Color.black));

        addLine(new Line(new Point(0,3), new Point(0,4), Color.black));
        addLine(new Line(new Point(0,3), new Point(1,3), Color.black));

        addLine(new Line(new Point(1,3), new Point(1,4), Color.black));
        addLine(new Line(new Point(1,3), new Point(2,3), Color.black));

        addLine(new Line(new Point(2,3), new Point(2,4), Color.black));

        addLine(new Line(new Point(0,4), new Point(1,4), Color.black));
        addLine(new Line(new Point(1,4), new Point(2,4), Color.black));

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
        for(Line l : lines){
            if(l.getStartPoint().equals(start) && l.getEndPoint().equals(end)){
                return l;
            }
        }
        return null;
    }

    public boolean containsLine(Point start, Point end){
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
