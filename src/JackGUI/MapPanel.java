package JackGUI;

import Beans.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 14.03.11
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class MapPanel extends JPanel {
    private static MapPanel instance;

    private Map myMap = new Map();

    public static MapPanel getInstance() {
        if (instance == null) {
            instance = new MapPanel();
        }
        return instance;
    }

    private MapPanel(){
        setSize(new Dimension(400, 400));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setBorder(BorderFactory.createLineBorder(Color.blue));

    }






}
