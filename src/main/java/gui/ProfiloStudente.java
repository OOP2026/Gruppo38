package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class ProfiloStudente {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JLabel matricolaLabel;
    private JLabel emailLabel;
    private JLabel annoCorsoLabel;
    private JPanel fieldPanel;
    private JPanel getPanel;
    private JButton ricercaButton;
    private JLabel getNomeLabel;
    private JLabel getCognomeLabel;
    private JLabel getMatricolaLabel;
    private JLabel getEmailLabel;
    private JLabel getAnnoCorsoLabel;
    private JPanel logoPanel;
    private JLabel logoLabel;

    public ProfiloStudente (JFrame mainFrame, Controller controller) {
        frame = new JFrame("Registrazione");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);
        getNomeLabel.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
            }
        });
    }
}
