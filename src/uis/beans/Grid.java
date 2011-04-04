package uis.beans;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 4/4/11
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Grid {
    protected ArrayList<CleanLine> lines = new ArrayList<CleanLine>();

    protected static Grid instance;

    public static Grid getInstance() {
        if (instance == null) {
            instance = new Grid();
        }
        return instance;

    }

    private Grid() {
    }


    public void add(int x1, int y1, int x2, int y2) {
        CleanLine cl = new CleanLine(new Point(x1, y1), new Point(x2, y2));
        if (!containsLine(x1, y1, x2, y2)) {
            lines.add(cl);
        }
    }

    public boolean remove(int x1, int y1, int x2, int y2) {
        CleanLine cl = new CleanLine(new Point(x1, y1), new Point(x2, y2));
        if (containsLine(x1, y1, x2, y2)) {
            lines.remove(cl);
            return true;
        }
        return false;
    }

    public boolean containsLine(int x1, int y1, int x2, int y2) {
        CleanLine cl = new CleanLine(new Point(x1, y1), new Point(x2, y2));
        for (CleanLine l : lines) {
            if (l.getStartPoint().equals(cl.getStartPoint()) && l.getEndPoint().equals(cl.getEndPoint())) {
                return true;
            } else if (l.getStartPoint().equals(cl.getEndPoint()) && l.getEndPoint().equals(cl.getStartPoint())) {
                return true;
            }
        }
        return false;
    }


}

