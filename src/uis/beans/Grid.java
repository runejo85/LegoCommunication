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


        public void addLine(CleanLine l){
        if(!containsLine(l.getStartPoint(), l.getEndPoint())) {
            lines.add(l);
        }

    }

        public void removeLine(CleanLine l){
        lines.remove(l);
    }

    public boolean containsLine(Point start, Point end) {
        for(CleanLine l : lines){
            if(l.getStartPoint().equals(start) && l.getEndPoint().equals(end)){
                return true;
            }
            else if (l.getStartPoint().equals(end) && l.getEndPoint().equals(start)) {
                return true;
            }
        }
        return false;
    }


}

