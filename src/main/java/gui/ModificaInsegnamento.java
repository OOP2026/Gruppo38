package gui;

import controller.Controller;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModificaInsegnamento {
    private JPanel mainPanel;
    private JPanel upperPanel;
    private JPanel buttonPanel;
    private JButton annullaButton;
    private JButton modificaInsegnamentoButton;
    private JPanel textPanel;
    private JPanel fieldPanel;
    private JTextField nomeField;
    private JComboBox<String> annoComboBox;
    private JLabel nomeLabel;
    private JLabel cfuLabel;
    private JLabel annoLabel;
    private JTextField cfuField;
    private JFrame frame;

    public ModificaInsegnamento(JFrame insegnamentoFrame, Controller controller, String login, int selectedIndex) {
        frame = new JFrame("Modifica Insegnamento");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        insegnamentoFrame.setVisible(false);
        String[] anno = {"-SELECT-", "PRIMO", "SECONDO", "TERZO"};
        DefaultComboBoxModel<String> annoModel = new DefaultComboBoxModel<>(anno);
        annoComboBox.setModel(annoModel);


        List<String> insegnamenti = controller.getDatiInsegnamento(login, selectedIndex);

        nomeField.setText(insegnamenti.get(0));
        cfuField.setText(insegnamenti.get(1));
        switch (insegnamenti.get(2)) {
            case "PRIMO":
                annoComboBox.setSelectedIndex(1);
                break;
            case "SECONDO":
                annoComboBox.setSelectedIndex(2);
                break;
            case "TERZO":
                annoComboBox.setSelectedIndex(3);
                break;
        }
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insegnamentoFrame.setVisible(true);
                frame.dispose();
            }
        });
        modificaInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.modificaInsegnamento(login, selectedIndex, nomeField.getText(), cfuField.getText(), annoComboBox.getSelectedItem().toString());
                insegnamentoFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
