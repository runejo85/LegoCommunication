package uis;

import java.awt.Color;

import uis.beans.FMap;
import uis.beans.IMap;
import uis.beans.Line;
import uis.beans.Point;

import java.lang.reflect.Field;

public class HelpFunctions {

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

    public static Point getClosestPoint(Point currPos, Point p1, Point p2) {
        int a = Math.abs(currPos.getX() - p1.getX()) + Math.abs(currPos.getY() - p1.getY());
        int b = Math.abs(currPos.getX() - p2.getX()) + Math.abs(currPos.getY() - p2.getY());
        if (a < b) return p1;
        else return p2;
    }

    public static int numberOfMoves(Point startPoint, Point endPoint) {
        int a = Math.abs(startPoint.getX() - endPoint.getX());
        int b = Math.abs(startPoint.getY() - endPoint.getY());
        return a + b;
    }

    /*
     array = findTarget((0,0), (0,1) endPos, 0);
     if(array


     */
    static IMap map = FMap.getInstance();

    public static Line[] findTarget(Point currPos, Point endPos, int moves) {

        Point newPointX = nextPointX(currPos, endPos);
        Point newPointY = nextPointY(currPos, endPos);
        Line[] lines;
        if (newPointY.equals(endPos)) {
            lines = new Line[moves+1];
            lines[moves] = new Line(currPos, newPointY, Color.black);
            return lines;
        } else if (newPointX.equals(endPos)) {
            lines = new Line[moves+1];
            lines[moves] = new Line(currPos, newPointX, Color.black);
            return lines;
        }

        if (map.containsLine(currPos, newPointX)) {

            lines = findTarget(newPointX, endPos, ++moves);
            if (lines != null) {
                lines[moves-1] = new Line(currPos, newPointX, Color.black);
                return lines;
            }
        } else if (map.containsLine(currPos, newPointY)) {

            lines = findTarget(newPointY, endPos, ++moves);
            if (lines != null) {
                lines[moves-1] = new Line(currPos, newPointY, Color.black);
                return lines;
            }

        }
        return null;
    }

    private static Point nextPointX(Point currPos, Point endPoint) {
        if (currPos.getX() > endPoint.getX()) {
            return new Point(currPos.getX() - 1, currPos.getY());
        } else {
            return new Point(currPos.getX() + 1, currPos.getY());
        }
    }

    private static Point nextPointY(Point currPos, Point endPoint) {
        if (currPos.getY() > endPoint.getY()) {
            return new Point(currPos.getX(), currPos.getY() - 1);
        } else {
            return new Point(currPos.getX(), currPos.getY() + 1);
        }
    }

    public static void main(String[] args) {
        Point startPoint = new Point(2, 4);
        Point endPoint = new Point(1, 1);
        Line[] lines = findTarget(startPoint, endPoint, 0);
        for(Line l : lines) {
            System.out.println(l);
        }
    }

}
