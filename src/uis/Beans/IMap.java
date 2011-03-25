package uis.Beans;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/25/11
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMap {

    public ArrayList<Line> getLines();
    public void addLine(Line l);
    public void removeLine(Line l);
    public Line getLine(Point start, Point end);
    public boolean containsLine(Point start, Point end);
    public boolean setLineColor(Point start, Point end, Color color);

}
