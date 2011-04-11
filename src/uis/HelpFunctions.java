package uis;

import java.awt.Color;

import uis.beans.*;
import uis.lego.ICommandConst;

import java.lang.reflect.Field;

public class HelpFunctions implements ICommandConst {

    public static String getColor(Color c) {
        if (c.equals(Color.red)) {
            return "red";
        } else if (c.equals(Color.black)) {
            return "black";
        } else if (c.equals(Color.blue)) {
            return "blue";
        } else if (c.equals(Color.green)) {
            return "green";
        } else if (c.equals(Color.yellow)) {
            return "yellow";
        } else if (c.equals(Color.white)) {
            return "white";
        }
        return null;
    }

    public static Color getColor(String s) {

        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField(s);
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;
    }

    public static Point[] sortPoints(Point p1, Point p2) {
        Point[] points = new Point[2];
        int a = (p1.getX() * 10) + p1.getY();
        int b = (p2.getX() * 10) + p2.getY();
        if (a < b) {
            points[0] = p1;
            points[1] = p2;
        } else {
            points[0] = p2;
            points[1] = p1;
        }
        return points;
    }

    public static Point getClosestPoint(Point currPos, Point p1, Point p2, Point declined) {
        if(declined != null) {
            if (declined.equals(p2)) {
                return p1;
            } else if(declined.equals(p1))  {
                return p2;
            }
        }
        int a = Math.abs(currPos.getX() - p1.getX()) + Math.abs(currPos.getY() - p1.getY());
        int b = Math.abs(currPos.getX() - p2.getX()) + Math.abs(currPos.getY() - p2.getY());
        if (a < b) return p1;
        else return p2;
    }

    public static Point getClosestPoint(Line closestLine, Line endLine, Point robotPos) {
        Point a = getClosestPoint(robotPos, endLine.getStartPoint(), endLine.getEndPoint(), null);
        Point b = getClosestPoint(a, closestLine.getStartPoint(), closestLine.getEndPoint(), null);
        return b;


    }

    public static int numberOfMoves(Point startPoint, Point endPoint) {
        int a = Math.abs(startPoint.getX() - endPoint.getX());
        int b = Math.abs(startPoint.getY() - endPoint.getY());
        return a + b;
    }

    public static int getRotation(Point currentPoint, Point nextPoint, int heading) {
        int rotation = -1;
        if(currentPoint.getX() < nextPoint.getX()) /* DRIVE WEST */  {
            switch(heading) {
                case 0: rotation = 1; break;
                case 1: rotation = 0; break;
                case 2: rotation = 3; break;
                case 3: rotation = 2; break;
            }
        } else if(currentPoint.getX() > nextPoint.getX()) /* DRIVE EAST */ {
            switch(heading) {
                case 0: rotation = 3; break;
                case 1: rotation = 2; break;
                case 2: rotation = 1; break;
                case 3: rotation = 0; break;
            }
        } else if(currentPoint.getY() < nextPoint.getY()) /* DRIVE  NORTH */ {
            switch(heading) {
                case 0: rotation = 0; break;
                case 1: rotation = 3; break;
                case 2: rotation = 2; break;
                case 3: rotation = 1; break;
            }
        }  else if(currentPoint.getY() > nextPoint.getY()) /* DRIVE SOUTH */ {
            switch(heading) {
                case 0: rotation = 2; break;
                case 1: rotation = 1; break;
                case 2: rotation = 0; break;
                case 3: rotation = 3; break;
            }
        }

        return rotation;
    }

    public static Point getOppositeEndOfLine(Point currPos, Line l) {
        if(currPos.equals(l.getStartPoint()))
            return l.getEndPoint();
        else
            return l.getStartPoint();

    }



    public static Point getNewPos(int heading, int length, Point currentPos) {
        Point newPos = null;
        if (heading == 0) {
            newPos = (new Point((currentPos.getX()), currentPos.getY() + length));
        } else if (heading == 1) {
            newPos = (new Point((currentPos.getX() + length), currentPos.getY()));

        } else if (heading == 2) {
            newPos = (new Point((currentPos.getX()), currentPos.getY() - length));

        } else if (heading == 3) {
            newPos = (new Point((currentPos.getX() - length), currentPos.getY()));
        }
        return newPos;
    }

    public static Point getSorterPos(Line line, int heading) {
        Point m = line.getMedian();
        switch(heading) {
            case NORTH:
                m.setY(m.getY() + 5);
                break;
            case SOUTH:
                m.setY(m.getY() - 5);
                break;
            case WEST:
                m.setX(m.getX() + 5);
                break;
            case EAST:
                m.setX(m.getX() - 5);
                break;
        }
        System.out.println(m + " from getSorterPos and heading is " + heading);
        return m;
    }
}
