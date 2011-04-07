package uis.gui;

import uis.beans.*;
import uis.lego.ICommandConst;

import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

public class MapPanel extends JPanel implements ICommandConst{
    private static MapPanel instance;

    private IMap myMap;

    public static MapPanel getInstance(IMap map) {
        if (instance == null) {
            instance = new MapPanel(map);
        }
        return instance;
    }

    public void setMap(IMap map) {
        myMap = map;
    }

    private MapPanel(IMap map){
        myMap = map;
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setBorder(BorderFactory.createLineBorder(Color.blue));
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Line> tempLines = myMap.getLines();
        ArrayList<Robot> tempRobots = myMap.getRobotPositions();
        int SCALING =  10;
        Point p1, p2;

        //g.translate(600,400);

        int yConst = 600;
        int xConst = 200;
        for (Line mapLine : tempLines) {
             p1 = mapLine.getStartPoint().reverse();
             p2 = mapLine.getEndPoint().reverse();

            Point m;
            g.setColor(Color.black);
            g.drawLine( (p1.getX() * SCALING) + xConst,
                     (p1.getY() * SCALING) + yConst,
                     (p2.getX() * SCALING) + xConst,  (p2.getY() * SCALING) + yConst);
            m = new Point((p1.getX() * SCALING + p2.getX() * SCALING)/ 2, (p1.getY() * SCALING + p2.getY() * SCALING) / 2) ;

            g.setColor(mapLine.getLineColor());
            g.fillOval((m.getX() ) + xConst - 3, (m.getY()) + yConst - 3, 6,6);
            g.setColor(Color.black);
            g.drawOval((m.getX() ) + xConst - 3, (m.getY()) + yConst - 3, 6,6);
        }

        for(Robot robot : tempRobots) {
            p1 = robot.getPosition().reverse();
            if(robot.getRobotName().equals("explorer2011")) {
                g.setColor(Color.orange);
            } else if (robot.getRobotName().equals("collector2011")) {
                g.setColor(Color.pink);
            }
            p2 = new Point(0,0);
            switch(robot.getHeading()) {
                case NORTH:
                    p2 = new Point(p1.getX(), p1.getY()-2);
                    break;
                case SOUTH:
                    p2 = new Point(p1.getX(), p1.getY()+2);
                    break;
                case WEST:
                    p2 = new Point(p1.getX()-2, p1.getY());
                    break;
                case EAST:
                    p2 = new Point(p1.getX()+2, p1.getY());
                    break;
            }
            g.fillOval((p1.getX() * SCALING ) + xConst - 5, (p1.getY() * SCALING) + yConst - 5, 10,10);
            g.setColor(Color.black);
            g.drawOval((p1.getX() * SCALING ) + xConst - 5, (p1.getY() * SCALING) + yConst - 5, 10,10);
            g.setColor(Color.gray);
            g.drawLine((p1.getX() * SCALING)+ xConst, (p1.getY() * SCALING) + yConst,(p2.getX() * SCALING) + xConst, (p2.getY() * SCALING) + yConst);
        }

    }








}
