package uis.beans;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 4/4/11
 * Time: 1:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CleanLine implements Serializable {
    	protected Point startPoint;
	protected Point endPoint;


	public CleanLine(Point p1, Point p2){
        setStartAndEndPoints(p1, p2);

    }

    public CleanLine (int x1, int y1, int x2, int y2) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2,y2);
        setStartAndEndPoints(p1, p2);
    }

    private void setStartAndEndPoints(Point p1, Point p2) {
        if(p1.lessThan(p2)) {
            startPoint = p1;
            endPoint = p2;
        } else {
            startPoint = p2;
            endPoint = p1;
        }
    }

	public Point getStartPoint(){
		return startPoint;
	}

	public Point getEndPoint(){
		return endPoint;
	}


    public boolean equals(CleanLine l) {
        if((this.startPoint.equals(l.startPoint) && this.endPoint.equals(l.endPoint)) ||
        (this.startPoint.equals(l.endPoint) && this.endPoint.equals(l.startPoint))) {
            return true;
        } else if (this.startPoint.equals(l.endPoint) && this.endPoint.equals(l.startPoint)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (" sP = " + startPoint + ", eP = " + endPoint);
    }
}
