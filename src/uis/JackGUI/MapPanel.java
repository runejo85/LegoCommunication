package uis.JackGUI;

import uis.Beans.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 14.03.11
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class MapPanel extends JPanel {
    private static MapPanel instance;
    private final int xConst = 600;
    private final int yConst = 600;
    private Map myMap;

    public static MapPanel getInstance() {
        if (instance == null) {
            instance = new MapPanel();
        }
        return instance;
    }

    private MapPanel(){
        myMap = Map.getInstance();
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setBorder(BorderFactory.createLineBorder(Color.blue));
        repaint();
    }

    public void init() {
        myMap = Map.getInstance();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Line> tempLines = myMap.getLines();
        double SCALING =  100;//1 / 5.0;

        //g.translate(600,400);

        for (Line mapLine : tempLines) {
            Point p1 = mapLine.getStartPoint().reverse();
            Point p2 = mapLine.getEndPoint().reverse();

            Point m;
            g.setColor(Color.black);
            g.drawLine((int) (p1.getX() * SCALING) + xConst,
                    (int) (p1.getY() * SCALING) + yConst,
                    (int) (p2.getX() * SCALING) + xConst, (int) (p2.getY() * SCALING) +yConst);
            m = new Point((int)(p1.getX() * SCALING + p2.getX() * SCALING)/ 2,(int) (p1.getY() * SCALING + p2.getY() * SCALING) / 2) ;
            g.setColor(mapLine.getLineColor());
            g.fillOval((int)(m.getX() ) + xConst - 3, (int)(m.getY()) + yConst - 3, 6,6);
        }


    }








}
