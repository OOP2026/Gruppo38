package gui;

import controller.Controller;
import exceptions.CampoVuotoException;

import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneStudente {
    private JPanel mainPanel;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registratiButton;
    private JButton annullaButton;
    private JTextField matricolaField;
    private JRadioButton primoRadioButton;
    private JRadioButton secondoRadioButton;
    private JRadioButton terzoRadioButton;
    private JPanel buttonPanel;
    private JPanel logoPanel;
    private JLabel logoLabel;
    private JLabel annoAccademicoLabel;
    private JLabel matricolaLabel;
    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JLabel emailLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private ButtonGroup annoGroup;
    private JFrame frame;

    public RegistrazioneStudente(JFrame mainFrame, Controller controller) {
        frame = new JFrame("Registrazione Studente");
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
                String matricola = matricolaField.getText();
                String selectedEnumStr;
                if(primoRadioButton.isSelected()) {
                    selectedEnumStr =  "PRIMO";
                }
                else if(secondoRadioButton.isSelected()) {
                    selectedEnumStr = "SECONDO";
                }
                else if(terzoRadioButton.isSelected()) {
                    selectedEnumStr = "TERZO";
                }
                else{
                    selectedEnumStr = "";
                }

                try{
                    controller.registrazioneStudente(login,password,nome,cognome,email,matricola,selectedEnumStr);
                    mainFrame.setVisible(true);
                    frame.dispose();
                } catch (AuthenticationException | LoginException | CampoVuotoException ex) {
                    JOptionPane.showMessageDialog(frame,"Login Error: " + ex.getMessage());
                }

            }
        });
    }
}
