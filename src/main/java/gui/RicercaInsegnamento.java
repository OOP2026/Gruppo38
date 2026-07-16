package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RicercaInsegnamento {
    private JPanel mainPanel;
    private JButton indietroButton;
    private JButton profiloButton;
    private JButton logOutButton;
    private JTextField insegnamentoField;
    private JList<String> insegnamentoList;
    private JLabel logoPanel;
    private JPanel rightPanel;
    private JPanel buttonPanel;
    private JPanel leftPanel;
    private JFrame frame;

    public RicercaInsegnamento(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Docente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ricercaFrame.setVisible(false);

        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ricercaFrame.setVisible(true);
                frame.dispose();
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                frame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
