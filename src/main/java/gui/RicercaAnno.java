package gui;

import controller.Controller;

import javax.swing.*;

public class RicercaAnno {
    private JPanel mainPanel;
    private JFrame frame;

    public RicercaAnno(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Anno");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
