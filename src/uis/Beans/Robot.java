package uis.Beans;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/30/11
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Robot {
    private String robotName;
    private Point position;

    public Robot(String robotName, Point position) {
        this.robotName = robotName;
        this.position = position;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
