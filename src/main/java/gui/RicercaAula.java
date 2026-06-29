package gui;

import controller.Controller;

import javax.swing.*;

public class RicercaAula {
    private JPanel mainPanel;
    private JFrame frame;

    public RicercaAula(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Docente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
