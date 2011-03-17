package uis.Beans;

import java.awt.Color;


public class Line {
	private Point startPoint;
	private Point endPoint;
    private Color lineColor;

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