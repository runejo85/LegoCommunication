package uis.lego;

import uis.beans.*;
import java.awt.Color;

public class FLegoCon {
    protected int heading;
    protected Point currentPos;
    IMap map;

    public FLegoCon(String name, String address, Point currentPos) {
        heading = 0;
        this.currentPos = currentPos;
        map = FMap.getInstance();
    }

    public Color travel(int dist, boolean checkColor) {
        Color c;
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
        Line l = map.getLine(oldPos, currentPos);
        c = l.getLineColor();
        if (checkColor) {
            return c;
        } else return null;
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
