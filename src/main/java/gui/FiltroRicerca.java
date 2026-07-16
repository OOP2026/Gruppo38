package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltroRicerca {
    private JPanel mainPanel;
    private JButton docentiButton;
    private JButton insegnamentiButton;
    private JButton annoCorsoButton;
    private JButton auleButton;
    private JButton logOutButton;
    private JButton profiloButton;
    private JLabel textLabel;
    private JPanel rightButtonPanel;
    private JPanel leftButtonPanel;
    private JPanel profiloTextPanel;
    private JPanel logOutPanel;
    private JFrame ricercaFrame;

    public FiltroRicerca(JFrame mainFrame, JFrame profileFrame, Controller controller) {
        ricercaFrame = new JFrame("Ricerca");
        ricercaFrame.setContentPane(mainPanel);
        ricercaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ricercaFrame.pack();
        profileFrame.setVisible(false);
        ricercaFrame.setVisible(true);
        ricercaFrame.setLocationRelativeTo(null);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ricercaFrame.dispose();
                profileFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                ricercaFrame.dispose();
            }
        });
        docentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RicercaDocente(mainFrame, profileFrame, ricercaFrame, controller);
            }
        });
        insegnamentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RicercaInsegnamento(mainFrame, profileFrame, ricercaFrame, controller);
            }
        });
        annoCorsoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RicercaAnno(mainFrame, profileFrame, ricercaFrame, controller);
            }
        });
        auleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RicercaAula(mainFrame, profileFrame, ricercaFrame, controller);
            }
        });
    }
}
