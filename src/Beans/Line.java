package Beans;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 14.03.11
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
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
    private String lineColor;

	public Line(Point startPoint, Point endPoint, String lColor){
		this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.lineColor = lColor;
	}

	public Point getStartPoint(){
		return startPoint;
	}

	public Point getEndPoint(){
		return endPoint;
	}

    public void serLineColor(String color){
        this.lineColor = color;
    }

    public String getLineColor(){
        return this.lineColor;
    }

}