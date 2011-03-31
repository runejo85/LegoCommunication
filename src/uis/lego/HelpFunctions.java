package uis.lego;

import java.awt.Color;
import uis.beans.Point;
import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/29/11
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
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


}
