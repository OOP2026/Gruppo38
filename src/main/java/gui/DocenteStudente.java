package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocenteStudente {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private JLabel decisioneLabel;
    private JButton docenteButton;
    private JButton studenteButton;
    private JButton homeButton;
    private JFrame frame;

    public DocenteStudente(JFrame mainFrame, Controller controller) {
        frame = new JFrame("Registrazione");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);
        docenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrazioneDocente(mainFrame,controller);
                frame.dispose();
            }
        });
        studenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrazioneStudente(mainFrame,controller);
                frame.dispose();
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
