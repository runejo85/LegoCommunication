package JackGUI;

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
        ControlPanel controlPanel = ControlPanel.getInstance();
        MapPanel mapPanel = MapPanel.getInstance();
        add(controlPanel, BorderLayout.WEST);
        add(mapPanel, BorderLayout.EAST);
        setTitle("Map gather l33t v1.32");


        setLayout(new BorderLayout());


    }

            public static void main(String[] args){
		GUI myFrame = new GUI();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}
}
