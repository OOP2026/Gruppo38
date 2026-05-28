package gui;

import controller.Controller;

import javax.swing.*;

public class SchermataPrincipale {
    private JPanel mainPanel;
    private JPanel rightPanel;
    private JButton docentiButton;
    private JButton insegnamentiButton;
    private JButton auleButton;
    private JButton giorniDellaSettimanaButton;
    private JLabel textLabel1;
    private JFrame frame;

    public SchermataPrincipale(JFrame mainFrame, Controller controller) {
        frame = new JFrame("Registrazione");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);
    }

}
