package gui;

import controller.Controller;
import model.AnnoAccademico;

import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField emailField;
    private JTextField usernameField;
    private JButton registratiButton;
    private JButton annullaButton;
    private JPasswordField passwordField;
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
    private ButtonGroup Responsabile;

    public RegistrazioneDocente(JFrame mainFrame, Controller controller) {
        frame = new JFrame("RegistrazioneDocente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        registratiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cognome = cognomeField.getText();
                String email = emailField.getText();
                String login = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String selectedEnumStr = Responsabile.getSelection().getActionCommand();
                System.out.println(selectedEnumStr);
                boolean isResponsabile = selectedEnumStr.equals("Si");

                try {
                    controller.registrazioneDocente(login,password,nome,cognome,email,isResponsabile);
                    mainFrame.setVisible(true);
                    frame.dispose();
                } catch (AuthenticationException | LoginException ex) {
                    JOptionPane.showMessageDialog(frame, "Login Error: " + ex.getMessage());
                }
            }
        });
    }
}
