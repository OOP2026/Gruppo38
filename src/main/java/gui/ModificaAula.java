package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaAula {
    private JPanel mainPanel;
    private JPanel upperPanel;
    private JPanel buttonPanel;
    private JButton annullaButton;
    private JButton modificaAulaButton;
    private JPanel textPanel;
    private JPanel fieldPanel;
    private JTextField nomeField;
    private JSpinner capienzaSpinner;
    private JLabel nomeLabel;
    private JLabel capienzaLabel;
    private JFrame frame;

    public ModificaAula(JFrame gestioneFrame, Controller controller, int selectedIndex) {
        frame = new JFrame("Modifica Insegnamento");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        gestioneFrame.setVisible(false);

        String[] aule = controller.getDatiAule(selectedIndex);

        nomeField.setText(aule[0]);
        SpinnerModel spinnerModel = new SpinnerNumberModel(Integer.parseInt(aule[1]), 20, 300, 10);
        capienzaSpinner.setModel(spinnerModel);

        modificaAulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificaAule(selectedIndex, nomeField.getText(), capienzaSpinner.getValue().toString());
                gestioneFrame.setVisible(true);
                frame.dispose();
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
