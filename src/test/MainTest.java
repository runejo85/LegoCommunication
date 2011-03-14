package test;

import BTConn.ExplorerCom;
import BTConn.ILegoCon;
import BTConn.LegoCon;
import GUI.CommandPanel;
import GUI.DisplayPanel;

import javax.swing.*;
import java.awt.*;

public class MainTest {



    public static void main(String[] args) {

        Point[] points = new Point[6];
//        points[0] = new Point(0, 0);
//        points[1] = new Point(2920, 0);
//        points[2] = new Point(2920, 2730);
//       // points[3] = new Point(1465, 2730);
//       // points[4] = new Point(1465, 1270);
//        points[3] = new Point(1650, 2730);
//        points[4] = new Point(1650, 1270);
//        points[5] = new Point(0, 1270);
        ILegoCon legoCon = new ExplorerCom("EXPLORER", "00:16:53:0f:30:89");


        //legoCon.sendCommand()



        points[0] = new Point(0, 0);
        points[1] = new Point(3000, 0);
        points[2] = new Point(3000, 500);
       // points[3] = new Point(1465, 2730);
       // points[4] = new Point(1465, 1270);
        points[3] = new Point(1500, 500);
        points[4] = new Point(1500, 1500);
        points[5] = new Point(0, 1500);




        JFrame myFrame = new JFrame();

        Container c = myFrame.getContentPane();
		DisplayPanel displayPanel = DisplayPanel.getInstance();
        displayPanel.init(points);
        CommandPanel commandPanel = new CommandPanel(legoCon);
        c.setLayout(new BorderLayout());
        c.add(commandPanel, BorderLayout.NORTH);
        c.add(displayPanel, BorderLayout.CENTER);
		myFrame.setSize(1000,1000);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);


    }
}
