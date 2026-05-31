package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton logOutButton;

    public ProfiloStudente (JFrame mainFrame, Controller controller, String login) {
        frame = new JFrame("Profilo Studente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(false);
        ArrayList<String> studente = controller.getAttributiStudente(login);

        getNomeLabel.setText(studente.get(0));
        getCognomeLabel.setText(studente.get(1));
        getMatricolaLabel.setText(studente.get(2));
        getEmailLabel.setText(studente.get(3));
        getAnnoCorsoLabel.setText(studente.get(4));

        frame.pack();
        frame.setVisible(true);

        ricercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ricerca(mainFrame,controller, login);
                frame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
