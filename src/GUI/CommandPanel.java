package GUI;

import BTConn.ILegoCon;
//import MCL.MCLocalization;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CommandPanel extends JPanel implements ActionListener {
    private JTextField moveDistField = new JTextField(4);
    private JTextField turnField = new JTextField(3);
    private JTextField sonarField = new JTextField(4);


    public int ping[];
    public ILegoCon legoC;


    public CommandPanel(ILegoCon con) {

        legoC = con;
        setSize(200, 20);
        initPanel();
    }

    private void initPanel() {
        JPanel upperPanel = new JPanel();
        upperPanel.setSize(new Dimension(55, 60));
        upperPanel.setLayout(new FlowLayout());
        JButton initialize = new JButton("Initialize");
        upperPanel.add(initialize);
        JButton disconnect = new JButton("Disconnect");
        upperPanel.add(disconnect);
        JPanel lowerPanel = new JPanel();
        lowerPanel.setSize(new Dimension(55, 60));
        lowerPanel.setLayout(new FlowLayout());
        JButton move = new JButton("Move");
        lowerPanel.add(move);
        lowerPanel.add(moveDistField);
        JLabel mmLabel = new JLabel("mm");
        lowerPanel.add(mmLabel);
        JButton turn = new JButton("Turn");
        lowerPanel.add(turn);
        lowerPanel.add(turnField);
        JLabel degreeLabel = new JLabel("deg");
        lowerPanel.add(degreeLabel);
        lowerPanel.add(sonarField);
        JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 500, 250);
        speedSlider.setFont(new Font("Serif", Font.ROMAN_BASELINE, 12));
        speedSlider.setMajorTickSpacing(100);
        speedSlider.setMinorTickSpacing(50);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        JPanel bottomPanel = new JPanel();
        JLabel speedLabel = new JLabel("Set Velocity:");
        bottomPanel.add(speedLabel);
        bottomPanel.add(speedSlider);
        setLayout(new FlowLayout());
        add(upperPanel);
        add(lowerPanel);
        add(bottomPanel);
        initialize.addActionListener(this);
        move.addActionListener(this);
        turn.addActionListener(this);
        Border _loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setBorder(_loweredetched);
    }


    public static void main(String[] args){
		JFrame myFrame = new JFrame();
		CommandPanel command = new CommandPanel(null);
		myFrame.getContentPane().add(command);
		myFrame.setSize(450,250);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}


    public void actionPerformed(ActionEvent e) {
        MCLocalization mcl = MCLocalization.getInstance();
        DisplayPanel disp = DisplayPanel.getInstance();

        if (e.getActionCommand().equals("Move")) {
            ping = legoC.sendCommand(2, (Integer.parseInt(moveDistField.getText())), 200);
            //mcl.moveParticles((Integer.parseInt(moveDistField.getText())), ping[0] * 10);

            //Test med oppgitt sonar i text
            //mcl.moveParticles((Integer.parseInt(moveDistField.getText())), (Integer.parseInt(sonarField.getText())));


            disp.repaint();
        } else if (e.getActionCommand().equals("Turn")) {
            ping = legoC.sendCommand(3, (Integer.parseInt(turnField.getText())), 200);
            //mcl.rotateParticles((Integer.parseInt(turnField.getText())), ping[0] * 10);

            //Test med oppgitt sonar i text
            //mcl.rotateParticles((Integer.parseInt(turnField.getText())), (Integer.parseInt(sonarField.getText())));


            disp.repaint();
        } else if (e.getActionCommand().equals("Initialize")) {
            mcl.resetDisplay();
            disp.repaint();
        } else if (e.getActionCommand().equals("Disconnect")) {
            boolean dc = true;
            int[] gg = legoC.sendCommand(4, 0, 0);
            for(int a : gg) {
                if (a != 255) {
                    dc = false;
                }
            }
            if(dc) {
                JOptionPane.showMessageDialog(this, "Successfully disconnected");
            } else {
                JOptionPane.showMessageDialog(this, "Disconnection failed!");
            }

        }
    }
}

