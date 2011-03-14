package JackGUI;

import javax.swing.*;

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
        setSize(1500, 900);
        initGUI();
    }

    private void initGUI() {
        ControlPanel controlPanel = ControlPanel.getInstance();


    }
}
