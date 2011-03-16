package JackGUI;

import Beans.Map;
import Beans.Line;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 14.03.11
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class GUI extends JFrame {

    private static GUI GUI;

    public static GUI getInstance() {
        if (GUI == null) {
            GUI = new GUI();
        }
        return GUI;
    }

    private GUI() {
        setSize(1500, 800);
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        ControlPanel controlPanel = ControlPanel.getInstance();
        MapPanel mapPanel = MapPanel.getInstance();
        add(controlPanel, BorderLayout.WEST);
        add(mapPanel, BorderLayout.CENTER);
        setTitle("Map gather l33t v1.322");


    }

    public static void main(String[] args) {

        Map map = Map.getInstance();
        map.addLine(new Line(new Point(0, 0), new Point(1, 0), "yellow"));
        map.addLine(new Line(new Point(0, 0), new Point(0, 1), "yellow"));
        map.addLine(new Line(new Point(1, 0), new Point(1, 1), "yellow"));
        map.addLine(new Line(new Point(0, 1), new Point(1, 1), "yellow"));
        map.addLine(new Line(new Point(0, 0), new Point(0, 1), "yellow"));
        map.addLine(new Line(new Point(0, 0), new Point(0, 1), "yellow"));
        map.addLine(new Line(new Point(0, -1), new Point(1, 1), "yellow"));
        map.addLine(new Line(new Point(-1, 0), new Point(1, 1), "yellow"));
        GUI myFrame = new GUI();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

    }
}
