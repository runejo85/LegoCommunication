package uis;

import uis.beans.Point;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 4/4/11
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindRoute {

        public  Point nextPointX(Point currPos, Point endPoint) {
        if (currPos.getX() == endPoint.getX()) {
            return currPos;
        } else if (currPos.getX() > endPoint.getX()) {
            return new Point(currPos.getX() - 1, currPos.getY());
        } else {
            return new Point(currPos.getX() + 1, currPos.getY());
        }
    }

    public  Point nextPointY(Point currPos, Point endPoint) {
        if (currPos.getY() == endPoint.getY()) {
            return currPos;
        } else if (currPos.getY() > endPoint.getY()) {
            return new Point(currPos.getX(), currPos.getY() - 1);
        } else {
            return new Point(currPos.getX(), currPos.getY() + 1);
        }
    }

        public  Point[] sortPoints(Point p1, Point p2) {
        Point[] points = new Point[2];
        int a = (p1.getX() * 10) + p1.getY();
        int b = (p2.getX() * 10) + p2.getY();
        if (a < b) {
            points[0] = p1;
            points[1] = p2;
        } else {
            points[0] = p2;
            points[1] = p1;
        }
        return points;
    }
}
