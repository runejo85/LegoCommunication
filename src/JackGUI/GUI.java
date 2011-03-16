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
        setTitle("Map gather l33t v1.32");


    }

    public static void main(String[] args) {

        Map map = Map.getInstance();
        map.addLine(new Line(new Point(100, 100), new Point(101, 100), "yellow"));
        map.addLine(new Line(new Point(100, 100), new Point(100, 101), "yellow"));
        map.addLine(new Line(new Point(101, 100), new Point(101, 101), "yellow"));
        map.addLine(new Line(new Point(100, 101), new Point(101, 101), "yellow"));
        map.addLine(new Line(new Point(100, 100), new Point(100, 99), "yellow"));
        map.addLine(new Line(new Point(100, 100), new Point(99, 100), "yellow"));
        map.addLine(new Line(new Point(100, 99), new Point(100, 100), "yellow"));
        map.addLine(new Line(new Point(99, 100), new Point(100, 100), "yellow"));
        GUI myFrame = new GUI();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

    }
}
