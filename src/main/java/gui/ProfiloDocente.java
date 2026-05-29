package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfiloDocente {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel logoPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JLabel logoLabel;
    private JPanel fieldPanel;
    private JPanel getPanel;
    private JButton insegnamentiButton;
    private JButton ricercaButton;
    private JButton modificaOrarioButton;
    private JLabel nomeLable;
    private JLabel cognomeLabel;
    private JLabel emailLabel;
    private JLabel responsabileLabel;
    private JLabel getNomeLabel;
    private JLabel getCognomeLabel;
    private JLabel getEmailLabel;
    private JLabel getResponsabileLabel;

    public ProfiloDocente (JFrame mainFrame, Controller controller, String login) {
        frame = new JFrame("Registrazione");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(false);
        ArrayList<String> docente = controller.getAttributiDocente(login);

        getNomeLabel.setText(docente.get(0));
        getCognomeLabel.setText(docente.get(1));
        getEmailLabel.setText(docente.get(2));
        getResponsabileLabel.setText(docente.get(3));


        if (!Boolean.parseBoolean(controller.getAttributiDocente(login).get(3))) {
            modificaOrarioButton.setToolTipText("Non sei Responsabile!");
            modificaOrarioButton.setEnabled(false);
        }

        frame.pack();
        frame.setVisible(true);


        modificaOrarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
