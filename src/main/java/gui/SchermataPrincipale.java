package gui;

import controller.Controller;

import javax.swing.*;

public class SchermataPrincipale {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private JPanel profileLabel;
    private JPanel leftLabel;
    private JPanel logoPanel;
    private JPanel emptyPanel;
    private JPanel rightPanel;
    private JButton docentiButton;
    private JButton materieButton;
    private JButton auleButton;
    private JButton giorniDellaSettimanaButton;
    private JLabel textLabel1;
    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JLabel matricolaLabel;
    private JLabel annoAccademicoLabel;
    private JFrame frame;

    public SchermataPrincipale(JFrame mainFrame, Controller controller) {
        frame = new JFrame("Registrazione");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);
    }

}
