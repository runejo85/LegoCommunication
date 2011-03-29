package uis.Beans;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/23/11
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.awt.Color;



public class FMap extends Map implements IMap  {

    private static FMap instance;

    public static FMap getInstance() {
        if (instance == null) {
            instance = new FMap();
        }
        return instance;

    }

    private FMap(){
        addLine(new Line(new Point(0,0), new Point(1,0), Color.black));
        addLine(new Line(new Point(0,0), new Point(0,1), Color.black));

        addLine(new Line(new Point(1,0), new Point(1,1), Color.black));
        addLine(new Line(new Point(1,0), new Point(2,0), Color.black));

        addLine(new Line(new Point(2,0), new Point(2,1), Color.black));

        addLine(new Line(new Point(0,1), new Point(1,1), Color.black));
        addLine(new Line(new Point(0,1), new Point(0,2), Color.black));

        addLine(new Line(new Point(1,1), new Point(1,2), Color.black));
        addLine(new Line(new Point(1,1), new Point(2,1), Color.black));

        addLine(new Line(new Point(2,1), new Point(2,2), Color.black));

        addLine(new Line(new Point(0,2), new Point(1,2), Color.black));
        addLine(new Line(new Point(0,2), new Point(0,3), Color.black));

        addLine(new Line(new Point(1,2), new Point(2,2), Color.black));
        addLine(new Line(new Point(1,2), new Point(1,3), Color.black));

        addLine(new Line(new Point(2,2), new Point(2,3), Color.black));

        addLine(new Line(new Point(0,3), new Point(0,4), Color.black));
        addLine(new Line(new Point(0,3), new Point(1,3), Color.black));

        addLine(new Line(new Point(1,3), new Point(1,4), Color.black));
        addLine(new Line(new Point(1,3), new Point(2,3), Color.black));

        addLine(new Line(new Point(2,3), new Point(2,4), Color.black));

        addLine(new Line(new Point(0,4), new Point(1,4), Color.black));
        addLine(new Line(new Point(1,4), new Point(2,4), Color.black));

    }
}
