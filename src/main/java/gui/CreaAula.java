package gui;

import controller.Controller;
import exceptions.CampoVuotoException;
import exceptions.CreaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaAula {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JSpinner capienzaSpinner;
    private JButton annullaButton;
    private JButton creaAulaButton;
    private JLabel capienzaLabel;
    private JLabel nomeLabel;
    private JPanel buttorPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JFrame frame;

    public CreaAula(JFrame gestioneFrame, Controller controller) {
        frame = new JFrame("Crea Insegnamento");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        gestioneFrame.setVisible(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        SpinnerModel spinnerModel = new SpinnerNumberModel(20, 20, 300, 10);
        capienzaSpinner.setModel(spinnerModel);

        creaAulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    String capienzaStr = capienzaSpinner.getValue().toString();

                    controller.aggiungiAula(nome, capienzaStr);
                    gestioneFrame.setVisible(true);
                    frame.dispose();
                } catch (CampoVuotoException | CreaException ex) {
                    JOptionPane.showMessageDialog(frame,"Errore creazione: " + ex.getMessage());
                }
            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioneFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
