package uis.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 4/5/11
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class PointGrid {


    HashMap<Point, Integer> pointHashMap = new HashMap<Point, Integer>();
    protected static PointGrid instance;

    public static PointGrid getInstance() {
        if (instance == null) {
            instance = new PointGrid();
        }
        return instance;

    }

    private PointGrid() {
    }

    public void add(Point point) {
        pointHashMap.put(point, 1000);
    }

    public void setWeight(Point point, int weight) {
        if(pointHashMap.get(point) > weight)
            pointHashMap.put(point, weight);
    }

    public int getWeight(Point point) {
        return pointHashMap.get(point);
    }

    public void resetWeight() {
        Set<Point> pointSet = pointHashMap.keySet();
        Iterator<Point> pointIterator = pointSet.iterator();
        while (pointIterator.hasNext()) {
            pointHashMap.put(pointIterator.next(), 1000);
        }
    }

    public boolean contains(Point point) {
        return pointHashMap.containsKey(point);
    }

    public boolean validNeighbour(Point point, int weight) {
        System.out.println(pointHashMap.get(point));
        return (contains(point) && (pointHashMap.get(point) > weight));
    }

    public String toString() {
        String a = "";
        Point p;
         Set<Point> pointSet = pointHashMap.keySet();
        Iterator<Point> pointIterator = pointSet.iterator();
        while (pointIterator.hasNext()) {
            p = pointIterator.next();
            a+= p;
            a+= " Weight: ";
            a+= pointHashMap.get(p);
            a += "\n";
        }
        return a;

    }


}
