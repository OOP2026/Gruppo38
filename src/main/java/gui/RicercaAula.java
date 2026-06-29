package gui;

import controller.Controller;

import javax.swing.*;

public class RicercaAula {
    private JPanel mainPanel;
    private JButton indietroButton;
    private JButton profiloButton;
    private JButton logOutButton;
    private JTextField auleField;
    private JList<String> auleList;
    private JPanel buttonPanel;
    private JLabel logoLabel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JFrame frame;

    public RicercaAula(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Aula");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
