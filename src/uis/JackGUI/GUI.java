package uis.JackGUI;

import uis.Beans.*;
import uis.Beans.Point;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;


public class GUI extends JFrame {

    private static GUI GUI;


    public static GUI getInstance(RobotControl explorerCtrl) {
        if (GUI == null) {
            GUI = new GUI(explorerCtrl);
        }
        return GUI;
    }

    private GUI(RobotControl explorerCtrl) {
        setSize(1500, 800);
        initGUI(explorerCtrl);
    }

    private void initGUI(RobotControl explorerCtrl) {
        setLayout(new BorderLayout());
        ControlPanel controlPanel = ControlPanel.getInstance(explorerCtrl);
        MapPanel mapPanel = MapPanel.getInstance();
        add(controlPanel, BorderLayout.WEST);
        add(mapPanel, BorderLayout.CENTER);
        setTitle("Map gather l33t v1.322");


    }

    public static void main(String[] args) {

        Map map = Map.getInstance();
        map.addLine(new Line(new Point(0, 0), new Point(1, 0), Color.blue));
        map.addLine(new Line(new Point(1, 0), new Point(1, 1), Color.yellow));
        map.addLine(new Line(new Point(0, 1), new Point(1, 1), Color.red));
        map.addLine(new Line(new Point(0, 0), new Point(0, 1), Color.yellow));
        map.addLine(new Line(new Point(0, 0), new Point(-1, 0), Color.yellow));
        map.addLine(new Line(new Point(-1, 0), new Point(-1, -1), Color.yellow));
        map.addLine(new Line(new Point(-1, -1), new Point(0, -1), Color.blue));
        map.addLine(new Line(new Point(0, -1), new Point(0,0), Color.green));
        GUI myFrame = new GUI(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

    }
}
