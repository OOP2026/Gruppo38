package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel leftPanel;
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton registratiButton;
    private JPanel rightPanel;
    private JButton loginButton1;
    private JPasswordField passwordField1;
    private JLabel psw;
    private JLabel user;
    private static JFrame frame;
    private static Controller controller;

    public static void main(String[] args) {
        controller = new Controller();
        frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Home().mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public Home() {
        registratiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrazioneStudente(frame,controller);
            }
        });
    }
}
