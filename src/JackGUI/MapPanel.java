package JackGUI;

import Beans.Line;
import Beans.Map;

import javax.swing.*;
import java.awt.*;
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



    }






}
