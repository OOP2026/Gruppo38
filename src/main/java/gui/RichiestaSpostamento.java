package gui;

import controller.Controller;

import javax.swing.*;

public class RichiestaSpostamento {
    private JPanel mainPanel;
    private JFrame frame;

    public RichiestaSpostamento(JFrame modificaOrarioFrame, Controller controller, String login) {
        frame = new JFrame("Modifica Orario");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modificaOrarioFrame.setVisible(false);
    }
}
