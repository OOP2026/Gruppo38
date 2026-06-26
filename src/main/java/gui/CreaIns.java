package gui;

import controller.Controller;
import exceptions.CampoVuotoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaIns {
    private JPanel mainPanel;
    private JPanel textPanel;
    private JTextField nomeField;
    private JButton annullaButton;
    private JButton creaInsegnamentoButton;
    private JPanel buttonPanel;
    private JComboBox annoComboBox;
    private JLabel nomeLabel;
    private JLabel cfuLabel;
    private JLabel annoLabel;
    private JPanel fieldPanel;
    private JPanel upperPanel;
    private JSpinner cfuSpinner;
    private JFrame frame;

    public CreaIns(JFrame insegnamentoFrame, Controller controller, String login) {
        frame = new JFrame("Crea Insegnamento");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        String[] anno = {"-SELECT-", "PRIMO", "SECONDO", "TERZO"};
        annoComboBox.setModel(new DefaultComboBoxModel<>(anno));

        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 0, 30, 1);
        cfuSpinner.setModel(spinnerModel);

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insegnamentoFrame.setVisible(true);
                frame.dispose();
            }
        });

        creaInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    String cfuStr = cfuSpinner.getValue().toString();
                    String annoCorsoStr = annoComboBox.getSelectedItem().toString();

                    controller.addInsegnamento(login, nome, cfuStr, annoCorsoStr);
                    insegnamentoFrame.setVisible(true);
                    frame.dispose();
                } catch (CampoVuotoException ex) {
                    JOptionPane.showMessageDialog(frame,"Errore creazione: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,"Errore formato: Il campo CFU deve contenere solo numeri validi!");
                }
            }
        });
    }
}
