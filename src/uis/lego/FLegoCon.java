package uis.lego;

import uis.beans.*;
import java.awt.Color;

public class FLegoCon {
    protected int heading;
    protected Point currentPos;

    public FLegoCon(String name, String address, Point currentPos) {
        heading = 0;
        this.currentPos = currentPos;
    }

    public Color travel(int dist, boolean checkColor) {
        Color c = Color.yellow;
        Point oldPos = currentPos;


        switch (heading) {
            case 0:
                currentPos = new Point(currentPos.getX(), currentPos.getY() + 1);
                break;
            case 1:
                currentPos = new Point(currentPos.getX() + 1, currentPos.getY());
                break;
            case 2:
                currentPos = new Point(currentPos.getX(), currentPos.getY() - 1);
                break;
            case 3:
                currentPos = new Point(currentPos.getX() - 1, currentPos.getY());
                break;
            default:
                System.out.println("Heading error in FExploreCom " + heading);
        }
        Line l = new Line(oldPos, currentPos, Color.black);
        if (l.equals(new Line(new Point(0, 3), new Point(1, 3), Color.black)) ||
                (l.equals(new Line(new Point(2, 0), new Point(2, 1), Color.black)))) {
            c = Color.green;
        }
        if (checkColor) {
            return c;
        } else return Color.white;
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

}
