package uis;

import uis.beans.Point;
import uis.beans.PointGrid;

import java.util.ArrayList;
import java.util.List;

public class LeeAlgorithm {

    private  static PointGrid pointGrid = PointGrid.getInstance();

    private static void weightGrid(Point startPoint, Point endPoint, int i) {
        List<Point> neighbourList = getNeighbours(startPoint, i);
        i++;
        for (Point p : neighbourList) {
            if (pointGrid.getWeight(p) > i) {
                pointGrid.setWeight(p, i);
                if (p.equals(endPoint)) return;
                weightGrid(p, endPoint, i);
            }
        }
    }

    private static void getShortestPath(Point endPoint, Point[] points) {
        int weight = pointGrid.getWeight(endPoint);
        List<Point> neighbourList = getNeighbours(endPoint, weight);
        for (Point p : neighbourList) {
            if(pointGrid.getWeight(p) == weight -1) {

                points[weight-1] = endPoint;
                endPoint = p;
                getShortestPath(endPoint, points);
                return;
            }
        }
        return;
    }


    public static Point[] getShortestPath(Point startPoint, Point endPoint) {
        pointGrid.setWeight(startPoint, 0);
        weightGrid(startPoint, endPoint, 0);
        Point[] points = new Point[pointGrid.getWeight(endPoint)];
        getShortestPath(endPoint, points);
        pointGrid.resetWeight();
        return points;
    }

    public static Point[] getShortestPath(Point startPoint, Point endPoint, Point unavailable) {
         if(endPoint.equals(unavailable)) {
            return alternativeRoute(startPoint, endPoint);

        }else if(unavailable != null) {
            pointGrid.setWeight(unavailable, -20);
        }
        pointGrid.setWeight(startPoint, 0);
        weightGrid(startPoint, endPoint, 0);
        Point[] points = new Point[pointGrid.getWeight(endPoint)];
        getShortestPath(endPoint, points);
        pointGrid.resetWeight();
        return points;
    }

    public static Point[] alternativeRoute(Point sP, Point eP) {
        Point[] route = null, route2 = null;
        if(sP.getY() == sP.getY()) {
            if(pointGrid.contains(new Point(eP.getX(), eP.getY()+10))) {
                route = getShortestPath(sP,new Point(eP.getX(), eP.getY()+10), eP);
            } else if(pointGrid.contains(new Point(eP.getX(), eP.getY()-10))) {
                route = getShortestPath(sP,new Point(eP.getX(), eP.getY()-10), eP);
            } else {
                System.err.println("no route found, fuckup");
                return null;
            }
        } else if (sP.getX() == sP.getX()) {
            if(pointGrid.contains(new Point(eP.getX() + 10, eP.getY()))) {
                route = getShortestPath(sP,new Point(eP.getX() + 10, eP.getY()), eP);
            } else if(pointGrid.contains(new Point(eP.getX() - 10, eP.getY()))) {
                route = getShortestPath(sP,new Point(eP.getX() - 10, eP.getY()), eP);
            } else {
                System.err.println("no route found, fuckup");
                return null;
            }

        }
        route2 = new Point[route.length + 1];
            for(int i = 0; i < route.length; i++) {
                route2[i] = route[i];
            }
            route2[route2.length-1] = eP;

        return route2;
    }

    private static List<Point> getNeighbours(Point p, int weight) {
        List<Point> pointList = new ArrayList<Point>();
        Point[] points = getN(p);
        for (int i = 0; i < points.length; i++) {
            if (pointGrid.contains(points[i])) {
                pointList.add(points[i]);
            }
        }
        return pointList;
    }

    private  static Point[] getN(Point p) {
        Point[] points = new Point[4];
        points[0] = new Point(p.getX() - 10, p.getY());
        points[1] = new Point(p.getX() + 10, p.getY());
        points[2] = new Point(p.getX(), p.getY() + 10);
        points[3] = new Point(p.getX(), p.getY() - 10);
        return points;
    }


    public static void main(String[] args) {





        LeeAlgorithm leeAlgorithm = new LeeAlgorithm();

        Point[] points = leeAlgorithm.getShortestPath(new Point(2,4), new Point(1,1));
        for(Point p : points)
            System.out.println(p);




    }

}
