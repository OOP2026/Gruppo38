package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel leftPanel;
    private JTextField usernameField;
    private JPanel mainPanel;
    private JButton registratiButton;
    private JPanel rightPanel;
    private JButton loginButton1;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel logoLabel;
    private JPanel logoPanel;
    private JPanel placeholderPanel;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
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
        loginButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {

                } catch (Controller.CampoVuotoException ex) {

                }*/
                new SchermataPrincipale(mainFrame,controller);
                mainFrame.setVisible(false);
            }
        });
    }
}
