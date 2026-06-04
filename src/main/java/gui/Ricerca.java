package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ricerca {
    private JPanel mainPanel;
    private JButton docentiButton;
    private JButton insegnamentiButton;
    private JButton giorniSettimanaButton;
    private JButton auleButton;
    private JButton logOutButton;
    private JButton profiloButton;
    private JLabel textLabel;
    private JPanel rightButtonPanel;
    private JPanel leftButtonPanel;
    private JPanel profiloTextPanel;
    private JPanel logOutPanel;
    private JFrame frame;

    public Ricerca(JFrame mainFrame, JFrame profileFrame, Controller controller) {
        frame = new JFrame("Ricerca");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        profileFrame.setVisible(false);
        frame.setVisible(true);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                profileFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
