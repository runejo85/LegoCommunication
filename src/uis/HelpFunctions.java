package uis;

import java.awt.Color;

import uis.beans.*;

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

    static IMap map = FMap.getInstance();


    public static Point[] findTarget(Point currPos, Point endPos, int moves) {
        Grid grid = Grid.getInstance();
        Point newPointX = nextPointX(currPos, endPos);
        Point newPointY = nextPointY(currPos, endPos);
        Point[] points;
        if (newPointY.equals(endPos)) {
            points = new Point[moves + 1];
            points[moves] = newPointY;
            return points;
        } else if (newPointX.equals(endPos)) {
            points = new Point[moves + 1];
            points[moves] =newPointX;
            return points;
        }
        if (grid.containsLine(currPos.getX(), currPos.getY(), newPointX.getX(), newPointX.getY())) {

            points = findTarget(newPointX, endPos, ++moves);
            if (points != null) {
                points[moves - 1] =newPointX;
                return points;
            }
        } else if (grid.containsLine(currPos.getX(), currPos.getY(), newPointY.getX(), newPointY.getY())) {

            points = findTarget(newPointY, endPos, ++moves);
            if (points != null) {
                points[moves - 1] = newPointY;
                return points;
            }

        }
        return null;
    }

    public static Point nextPointX(Point currPos, Point endPoint) {
        if (currPos.getX() == endPoint.getX()) {
            return currPos;
        } else if (currPos.getX() > endPoint.getX()) {
            return new Point(currPos.getX() - 1, currPos.getY());
        } else {
            return new Point(currPos.getX() + 1, currPos.getY());
        }
    }

    public static Point nextPointY(Point currPos, Point endPoint) {
        if (currPos.getY() == endPoint.getY()) {
            return currPos;
        } else if (currPos.getY() > endPoint.getY()) {
            return new Point(currPos.getX(), currPos.getY() - 1);
        } else {
            return new Point(currPos.getX(), currPos.getY() + 1);
        }
    }

    public int getRotation(Point currPoint, Point nextPoint, int heading) {
        int rotation = -1;
        if(currPoint.getX() < nextPoint.getX()) {
            rotation = Math.abs(heading - 0);
        } else if(currPoint.getX() > nextPoint.getX()) {
            rotation = Math.abs(heading - 1);
        } else if(currPoint.getY() < nextPoint.getY()) {
            rotation = Math.abs(heading - 2);
        }  else if(currPoint.getY() > nextPoint.getY()) {
            rotation = Math.abs(heading - 3);
        }

        return rotation;
    }

    public static void main(String[] args) {
        Grid grid = Grid.getInstance();
        grid.add(0,0,1,0);
        grid.add(0,0,0,1);

        grid.add(1,0,1,1);
        grid.add(1,0,2,0);

        grid.add(2,0,2,1);

        grid.add(0,1,1,1);
        grid.add(0,1,0,2);

        grid.add(1,1,1,2);
        grid.add(1,1,2,1);

        grid.add(2,1,2,2);

        grid.add(0,2,1,2);
        grid.add(0,2,0,3);

        grid.add(1,2,2,2);
        grid.add(1,2,1,3);

        grid.add(2,2,2,3);

        grid.add(0,3,0,4);
        grid.add(0,3,1,3);

        grid.add(1,3,1,4);
        grid.add(1,3,2,3);

        grid.add(2,3,2,4);

        grid.add(0,4,1,4);
        grid.add(1,4,2,4);
        Point startPoint = new Point(2, 3);
        Point endPoint = new Point(0, 0);
        Point[] lines = findTarget(startPoint, endPoint, 0);
        for (Point l : lines) {
            System.out.println(l);
        }
    }

}
