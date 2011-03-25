package uis.JackGUI;

import uis.Beans.*;
import uis.Beans.Point;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;


public class GUI extends JFrame {

    private static GUI GUI;


    public static GUI getInstance(RobotControl rc) {
        if (GUI == null) {
            GUI = new GUI(rc);
        }
        return GUI;
    }

    private GUI(RobotControl rc) {
        setSize(1500, 800);
        initGUI(rc);
    }

    private void initGUI(RobotControl rc) {
        setLayout(new BorderLayout());
        ControlPanel controlPanel = ControlPanel.getInstance(rc);
        MapPanel mapPanel = MapPanel.getInstance();
        add(controlPanel, BorderLayout.WEST);
        add(mapPanel, BorderLayout.CENTER);
        setTitle("Map gather l33t v1.322");


    }

    public static void main(String[] args) {

        Map map = Map.getInstance();
        map.addLine(new Line(new Point(0,0), new Point(1,0), Color.black));
        map.addLine(new Line(new Point(0,0), new Point(0,1), Color.black));

        map.addLine(new Line(new Point(1,0), new Point(1,1), Color.black));
        map.addLine(new Line(new Point(1,0), new Point(2,0), Color.black));

        map.addLine(new Line(new Point(2,0), new Point(2,1), Color.black));

        map.addLine(new Line(new Point(0,1), new Point(1,1), Color.black));
        map.addLine(new Line(new Point(0,1), new Point(0,2), Color.black));

        map.addLine(new Line(new Point(1,1), new Point(1,2), Color.black));
        map.addLine(new Line(new Point(1,1), new Point(2,1), Color.black));

        map.addLine(new Line(new Point(2,1), new Point(2,2), Color.black));

        map.addLine(new Line(new Point(0,2), new Point(1,2), Color.black));
        map.addLine(new Line(new Point(0,2), new Point(0,3), Color.black));

        map.addLine(new Line(new Point(1,2), new Point(2,2), Color.black));
        map.addLine(new Line(new Point(1,2), new Point(1,3), Color.black));

        map.addLine(new Line(new Point(2,2), new Point(2,3), Color.black));

        map.addLine(new Line(new Point(0,3), new Point(0,4), Color.black));
        map.addLine(new Line(new Point(0,3), new Point(1,3), Color.black));

        map.addLine(new Line(new Point(1,3), new Point(1,4), Color.black));
        map.addLine(new Line(new Point(1,3), new Point(2,3), Color.black));

        map.addLine(new Line(new Point(2,3), new Point(2,4), Color.black));

        map.addLine(new Line(new Point(0,4), new Point(1,4), Color.black));
        map.addLine(new Line(new Point(1,4), new Point(2,4), Color.black));
        GUI myFrame = new GUI(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);



    }
}
