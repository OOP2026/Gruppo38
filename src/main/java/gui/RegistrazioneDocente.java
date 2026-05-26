package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField1;
    private JButton registratiButton;
    private JButton annullaButton;
    private JTextField passwordField;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JPanel logoPanel;
    private JLabel logoLabel;
    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JLabel emailLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel responsabileLabel;
    private JRadioButton radioButton3;
    private JPanel buttonPanel;
    private JFrame frame;

    public RegistrazioneDocente(JFrame mainFrame, Controller controller) {
        frame = new JFrame("RegistrazioneDocente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
