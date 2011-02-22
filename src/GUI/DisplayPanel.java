package GUI;

import MCL.Line;
import MCL.MCLocalization;
import MCL.Point;
import MCL.Pose;

import javax.swing.*;
import java.awt.*;


public class DisplayPanel extends JPanel {


    private Pose[] poseSet;
    private Line[] boundaryLines;
    MCLocalization mcl;

    private static DisplayPanel instance;

    public static DisplayPanel getInstance() {
        if (instance == null) {
            instance = new DisplayPanel();
        }
        return instance;
    }

    private DisplayPanel() {
        setSize(new Dimension(400, 400));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    public void init(Point[] points) {
        mcl = MCLocalization.getInstance();
        mcl.init(points);
        poseSet = mcl.resetDisplay();
        boundaryLines = mcl.getLines();

    }


    public void paintComponent(Graphics g) {
        poseSet = mcl.getPoses();
        super.paintComponent(g);
        double SCALING = 1 / 5.0;
        g.setColor(Color.red);
        for (Pose aPoseSet : poseSet) {
            if(aPoseSet.isValid()){
                g.fillOval((int) (aPoseSet.getPoint().getX() * SCALING),
                        (int) (aPoseSet.getPoint().getY() * SCALING), 2, 2);
            }
        }
        g.setColor(Color.black);

        for (Line boundaryLine : boundaryLines) {
            Point p1 = boundaryLine.getStartPoint();
            Point p2 = boundaryLine.getEndPoint();
            g.drawLine((int) (p1.getX() * SCALING),
                    (int) (p1.getY() * SCALING),
                    (int) (p2.getX() * SCALING), (int) (p2.getY() * SCALING));
        }
    }
}
