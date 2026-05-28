package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfiloDocente {

    private JFrame frame;
    private JPanel mainPanel;

    public ProfiloDocente (JFrame mainFrame, Controller controller) {
        frame = new JFrame("Registrazione");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);
    }
}
