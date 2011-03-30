package uis.lego;

import uis.Beans.FMap;
import uis.Beans.IMap;
import uis.Beans.Point;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/23/11
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class FExplorerCom implements IExplorerCom {
    Point currentPos;
    int heading = 0;
    IMap fMap;


    public FExplorerCom(String name, String adress) {
        currentPos = new Point(0, 0);
        fMap = FMap.getInstance();
    }

    public int[] sweep() {
        int hlp;
        switch (heading) {
            case 0:
                hlp = 4;
                break;
            case 1:
                hlp = 3;
                break;
            case 2:
                hlp = 2;
                break;
            case 3:
                hlp = 1;
                break;
            default:
                hlp = 1;
        }


        int[] result = new int[4];
        if (fMap.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() + 1))) {
            result[(hlp) % 4] = 1;
        }
        if (fMap.containsLine(currentPos, new Point(currentPos.getX() + 1, currentPos.getY()))) {

            result[(1 + hlp) % 4] = 1;
        }
        if (fMap.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() - 1))) {
            result[(2 + hlp) % 4] = 1;
        }
        if (fMap.containsLine(currentPos, new Point(currentPos.getX() - 1, currentPos.getY()))) {
            result[(3 + hlp) % 4] = 1;
        }


        return result;
    }

    public Color travel(int dist, boolean checkColor) {
        Random rnd = new Random();
        Color c = Color.white;

        switch (heading) {
            case 0:
                currentPos = new Point(currentPos.getX(), currentPos.getY() + 1);
                c = Color.blue;
                break;
            case 1:
                currentPos = new Point(currentPos.getX() + 1, currentPos.getY());
                c = Color.yellow;
                break;
            case 2:
                currentPos = new Point(currentPos.getX(), currentPos.getY() - 1);
                c = Color.green;
                break;
            case 3:
                currentPos = new Point(currentPos.getX() - 1, currentPos.getY());
                c = Color.red;
                break;
            default:
                System.out.println("Heading error in FExploreCom " + heading);
        }
        if (checkColor) {
            //return getColor(rnd.nextInt(5) + 2);
            return c;
        } else return Color.black;
    }

    public boolean turn(int degrees) {
        int a = degrees / 90;
        if (a == -1) {
            a = 3;
        }
        heading = (heading + a) % 4;
        return true;
    }

    public boolean disconnect() {
        return true;

    }

    public String getPos() {
        return ("X: " + currentPos.getX() + " Y: " + currentPos.getY());
    }

    public static void main(String[] args) {
//        FExplorerCom fExplorerCom = new FExplorerCom("", "");
//        int[] gg = fExplorerCom.sweep();
//        for (int i : gg) {
//            System.out.println(i);
//        }

        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField("yellow");
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        System.out.println(color.toString());
        color = Color.red;
        System.out.println(getColor(color));

    }

    private Color getColor(int i) {
        switch (i) {
            case 0:
                return null;
            case 1:
                return Color.black;
            case 2:
                return Color.blue;
            case 3:
                return Color.green;
            case 4:
                return Color.yellow;
            case 5:
                return Color.red;
            case 6:
                return Color.white;
            default:
                return Color.white;
        }
    }

    private static String getColor(Color c) {
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
}


