package GUI;


import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 1/25/11
 * Time: 3:34 PM
 */
public class Line {
	private Point startPoint;
	private Point endPoint;

	public Line(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
        this.endPoint = endPoint;
	}

	public Point getStartPoint(){
		return startPoint;
	}

	public Point getEndPoint(){
		return endPoint;
	}

}