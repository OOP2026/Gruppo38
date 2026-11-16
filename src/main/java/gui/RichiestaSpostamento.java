package gui;

import controller.Controller;

import javax.swing.*;

public class RichiestaSpostamento {
    private JPanel mainPanel;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JComboBox comboBox1;
    private JFrame frame;

    public RichiestaSpostamento(JFrame modificaOrarioFrame, Controller controller, String login) {
        frame = new JFrame("Modifica Orario");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modificaOrarioFrame.setVisible(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
