package gui;

import controller.Controller;

import javax.swing.*;

public class RicercaAnno {
    private JPanel mainPanel;
    private JList annoList;
    private JComboBox annoComboBox;
    private JButton indietroButton;
    private JButton logOutButton;
    private JButton profiloButton;
    private JLabel logoLabel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel buttonPanel;
    private JFrame frame;

    public RicercaAnno(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Anno");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
