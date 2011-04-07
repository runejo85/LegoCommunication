package uis.gui;

import uis.beans.*;
import uis.beans.Point;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;


public class GUI extends JFrame {

    private static GUI GUI;
    private IMap map;


    public static GUI getInstance(RobotControl rc) {
        if (GUI == null) {
            GUI = new GUI(rc);
        }
        return GUI;
    }

    private GUI(RobotControl rc) {
        setSize(1200, 800);
        map = Map.getInstance();
        initGUI(rc);
    }

    private void initGUI(RobotControl rc) {
        setLayout(new BorderLayout());
        ControlPanel controlPanel = ControlPanel.getInstance(rc);
        MapPanel mapPanel = MapPanel.getInstance(map);
        add(controlPanel, BorderLayout.WEST);
        add(mapPanel, BorderLayout.CENTER);
        setTitle("Map gather l33t v1.322");


    }

    public boolean setLineColor(Point p1, Point p2, Color color) {
        boolean ret = map.setLineColor(p1, p2, color);
        repaint();
        return ret;
    }

    public boolean addLine(Line line) {
        map.addLine(line);
        repaint();
        return true;
    }

    public IMap getMap() {
        return map;
    }

    public void setMap(IMap map) {
        this.map = map;
        MapPanel.getInstance(null).setMap(map);
    }

    public boolean updateRobotPos(Point point, String robotName, int heading) {
        map.addRobot(robotName, point, heading);
        repaint();
        return true;
    }

    public Robot getRobot() {
        return map.getRobotPositions().get(0);
    }



    public static void main(String[] args) {

        GUI gui = new GUI(null);
        gui.setMap(FMap.getInstance());
        gui.repaint();
//        gui.addLine(new Line(new Point(0,0), new Point(0,10), Color.black));
//
//        gui.addLine(new Line(new Point(10,0), new Point(10,10), Color.yellow));
//        gui.addLine(new Line(new Point(10,0), new Point(20,0), Color.red));
//
//        gui.addLine(new Line(new Point(20,0), new Point(20,10), Color.yellow));
//
//        gui.addLine(new Line(new Point(0,10), new Point(10,10), Color.yellow));
//        gui.addLine(new Line(new Point(0,10), new Point(0,20), Color.black));
//
//        gui.addLine(new Line(new Point(10,10), new Point(10,20), Color.red));
//        gui.addLine(new Line(new Point(10,10), new Point(20,10), Color.black));
//
//        gui.addLine(new Line(new Point(20,10), new Point(20,20), Color.blue));
//
//        gui.addLine(new Line(new Point(0,20), new Point(10,20), Color.black));
//        gui.addLine(new Line(new Point(0,20), new Point(0,30), Color.green));
//
//        gui.addLine(new Line(new Point(10,20), new Point(20,20), Color.green));
//        gui.addLine(new Line(new Point(10,20), new Point(10,30), Color.black));
//
//        gui.addLine(new Line(new Point(20,20), new Point(20,30), Color.black));
//
//        gui.addLine(new Line(new Point(0,30), new Point(0,40), Color.black));
//        gui.addLine(new Line(new Point(0,30), new Point(10,30), Color.black));
//
//        gui.addLine(new Line(new Point(10,30), new Point(10,40), Color.black));
//        gui.addLine(new Line(new Point(10,30), new Point(20,30), Color.black));
//
//        gui.addLine(new Line(new Point(20,30), new Point(20,40), Color.green));
//
//        gui.addLine(new Line(new Point(0,40), new Point(10,40), Color.black));
//        gui.addLine(new Line(new Point(10,40), new Point(20,40), Color.black));

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);

    }


}
