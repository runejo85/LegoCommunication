package uis.Beans;

import java.util.ArrayList;
import java.awt.Color;



public class Map implements IMap {
    protected ArrayList<Line> lines = new ArrayList<Line>();
    protected ArrayList<Robot> robotPositions = new ArrayList<Robot>();
    protected static Map instance;

    public static IMap getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;

    }


    protected Map(){

    }

    public void updateRobotPos(String name, Point pos) {
        for(Robot r : robotPositions) {
            if(r.getRobotName().equals(name)) {
                r.setPosition(pos);
            }
        }
    }


    public void addRobot(String name, Point pos) {
        boolean found = false;
        for(Robot r : robotPositions) {
            if (r.getRobotName().equals(name)) {
                updateRobotPos(name, pos);
                found = true;
                break;
            }
        }
        if(!found) {
            robotPositions.add(new Robot(name, pos));
        }

    }

    public ArrayList<Robot> getRobotPositions() {
        return robotPositions;
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
