package JackGUI;

import BTConn.ILegoCon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel extends JPanel implements ActionListener {

    private static ControlPanel controlPanel;

    public static ControlPanel getInstance() {
        if (controlPanel == null) {
            controlPanel = new ControlPanel();
        }
        return controlPanel;
    }

    private ControlPanel() {
        setSize(400, 400);
        initPanel();
    }

    private void initPanel() {

        setLayout(new BorderLayout());

        JButton initButton = new JButton("Initialize Connections");
        JButton dcButton = new JButton("Disconnect");
        JPanel conPanel = addPanel("Connections..", initButton, dcButton);
        add(conPanel, BorderLayout.NORTH);

        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JPanel optionsPanel = addPanel("Options..", startButton, pauseButton);
        add(optionsPanel, BorderLayout.SOUTH);






    }

    private JPanel addPanel(String header, JButton... buttons) {
         JPanel panel = new JPanel(new GridLayout(1, 2));
         Border border = BorderFactory.createTitledBorder(header);
        panel.setBorder(border);
        for(JButton b : buttons) {
            panel.add(b);
        }

        return panel;

    }

        public static void main(String[] args){
		JFrame myFrame = new JFrame();
		ControlPanel command = new ControlPanel();
		myFrame.getContentPane().add(command);
		myFrame.setSize(400,400);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}


    public void actionPerformed(ActionEvent actionEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
