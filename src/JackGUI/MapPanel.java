package JackGUI;

import Beans.Map;

import javax.swing.*;

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



}
