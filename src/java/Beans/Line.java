package java.Beans;

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
    private Color lineColor;

    private int lol;

	public Line(Point startPoint, Point endPoint, Color lColor){
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

    public void setLineColor(Color color){
        this.lineColor = color;
    }

    public Color getLineColor(){
        return this.lineColor;
    }

    public void lol() {
        int a = 4;
    }

}