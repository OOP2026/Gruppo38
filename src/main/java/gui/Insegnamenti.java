package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insegnamenti {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JList insegnamentiList;
    private JLabel ListaLabel;
    private JButton creaNuovoInsegnamentoButton;
    private JPanel buttonPanel;
    private JButton profiloButton;
    private JButton logOutButton;
    private JFrame insegnamentoFrame;

    public Insegnamenti(JFrame mainFrame, JFrame profileFrame, Controller controller, String login) {
        insegnamentoFrame = new JFrame("Insegnamenti");
        insegnamentoFrame.setContentPane(mainPanel);
        insegnamentoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insegnamentoFrame.pack();
        insegnamentoFrame.setVisible(true);

        creaNuovoInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreaIns(insegnamentoFrame, controller, login);
                insegnamentoFrame.dispose();
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                insegnamentoFrame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                insegnamentoFrame.dispose();
            }
        });
    }
}
