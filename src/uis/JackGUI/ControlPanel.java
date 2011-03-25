package uis.JackGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel extends JPanel implements ActionListener {

    private static ControlPanel controlPanel;
    private RobotControl explorerCtrl;

    public static ControlPanel getInstance(RobotControl explorerCtrl) {
        if (controlPanel == null) {
            controlPanel = new ControlPanel(explorerCtrl);
        }
        return controlPanel;
    }

    private ControlPanel(RobotControl explorerCtrl) {
        if (explorerCtrl != null) {
            this.explorerCtrl = explorerCtrl;
        }
        initPanel();
    }

    private void initPanel() {

        setLayout(new BorderLayout());

        JButton initButton = new JButton("Initialize Connections");
        JButton dcButton = new JButton("Disconnect");
        JPanel conPanel = addPanel("Connections..", initButton, dcButton);
        dcButton.addActionListener(this);
        initButton.addActionListener(this);
        add(conPanel, BorderLayout.NORTH);

        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        startButton.addActionListener(this);
        pauseButton.addActionListener(this);
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
		ControlPanel command = new ControlPanel(null);
		myFrame.getContentPane().add(command);
		myFrame.setSize(400,400);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Initialize Connections")) {
            explorerCtrl.btConnect();
            System.out.println("Initialize Connections");
        }
        else if (e.getActionCommand().equals("Disconnect")) {
            explorerCtrl.btDisconnect();
            System.out.println("Disconnect");
        }
        else if (e.getActionCommand().equals("Start")) {
            System.out.println("Start");
            explorerCtrl.start ();
        }
        else if (e.getActionCommand().equals("Pause")) {
            System.out.println("Pause");
        }
    }
}
