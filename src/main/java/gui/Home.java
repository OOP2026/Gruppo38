package gui;

import controller.Controller;
import exceptions.CampoVuotoException;
import exceptions.MissingStudentException;
import exceptions.MissingTeacherException;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel leftPanel;
    private JTextField usernameField;
    private JPanel mainPanel;
    private JButton registratiButton;
    private JPanel rightPanel;
    private JButton loginStudente;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel logoLabel;
    private JPanel logoPanel;
    private JPanel placeholderPanel;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private JButton loginStudenteButton;
    private JButton loginDocenteButton;
    private static JFrame mainFrame;
    private static Controller controller;

    public static void main(String[] args) {
        controller = new Controller();
        mainFrame = new JFrame("Home");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(new Home().mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public Home() {
        registratiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DocenteStudente(mainFrame,controller);
            }
        });
        loginStudenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login,password;
                login = usernameField.getText();
                password = passwordField.getText();

                try {
                    if(controller.loginStudente(login,password))
                        new SchermataPrincipale(mainFrame,controller);
                } catch (CampoVuotoException | LoginException | MissingStudentException ex) {
                    JOptionPane.showMessageDialog(mainFrame,ex.getMessage());
                }
            }
        });

        loginDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login,password;
                login = usernameField.getText();
                password = passwordField.getText();

                try {
                    if(controller.loginDocente(login,password))
                        new SchermataPrincipale(mainFrame,controller);
                } catch (CampoVuotoException | LoginException | MissingTeacherException ex) {
                    JOptionPane.showMessageDialog(mainFrame,ex.getMessage());
                }

            }
        });
    }
}
