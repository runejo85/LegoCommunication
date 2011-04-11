package uis.lego;

import uis.beans.*;
import uis.lego.collector.CollectorCom;
import uis.lego.collector.FCollectorCom;

import java.awt.Color;

public class FLegoCon implements ICommandConst {
    protected int heading;
    protected Point currentPos;
    protected IMap map;

    public FLegoCon(String name, String address, Point currentPos) {
        heading = 0;
        this.currentPos = currentPos;
        map = FMap.getInstance();
    }

    public Color travel(int dist, boolean checkColor) {
        Color c;
        Point oldPos = currentPos;
        switch (heading) {
            case NORTH:
                currentPos = new Point(currentPos.getX(), currentPos.getY() + dist / 50);
                break;
            case EAST:
                currentPos = new Point(currentPos.getX() + dist / 50, currentPos.getY());
                break;
            case SOUTH:
                currentPos = new Point(currentPos.getX(), currentPos.getY() - dist / 50);
                break;
            case WEST:
                currentPos = new Point(currentPos.getX() - dist / 50, currentPos.getY());
                break;
            default:
                System.out.println("Heading error in FLegoCon " + heading);
        }
        if (checkColor) {
            Line l = map.getLine(oldPos, currentPos);
            c = l.getLineColor();
            return c;
        } else return null;
    }

    public boolean turn(int degrees) {

        int a = degrees / 90;
        a = (a + 4) % 4;
        heading = (heading + a) % 4;
        if(this instanceof FCollectorCom)
        System.out.println("ROBOT IS TURNING, HEAING IS" + heading);
        return true;
    }

    public boolean disconnect() {
        return true;

    }

    public String getPos() {
        return ("X: " + currentPos.getX() + " Y: " + currentPos.getY());
    }

}
