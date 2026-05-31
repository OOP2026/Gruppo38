package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaIns {
    private JPanel mainPanel;
    private JPanel textPanel;
    private JTextField nomeField;
    private JTextField cfuField;
    private JButton annullaButton;
    private JButton creaInsegnamentoButton;
    private JPanel buttonPanel;
    private JComboBox annoComboBox;
    private JLabel nomeLabel;
    private JLabel cfuLabel;
    private JLabel annoLabel;
    private JPanel fieldPanel;
    private JPanel upperLabel;
    private JFrame frame;

    public CreaIns(JFrame insegnamentoFrame, Controller controller, String login) {
        frame = new JFrame("Crea Insegnamento");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insegnamentoFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
