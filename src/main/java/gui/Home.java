package gui;

import controller.Controller;
import exceptions.CampoVuotoException;
import exceptions.MissingStudentException;
import exceptions.MissingTeacherException;

import javax.imageio.ImageIO;
import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home {
    private JPanel leftPanel;
    private JTextField usernameField;
    private JPanel mainPanel;
    private JButton registrazioneStudenteButton;
    private JPanel rightPanel;
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
    private JButton registrazioneDocenteButton;
    private static JFrame mainFrame;
    private static Controller controller;
    private BufferedImage logo;

    public static void main(String[] args) {
        controller = new Controller();
        mainFrame = new JFrame("Home");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(new Home().mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public Home() {

        try {
            logo = ImageIO.read(new File("src/main/java/gui/image/fed2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logoLabel.setIcon(new ImageIcon(logo));

        registrazioneStudenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrazioneStudente(mainFrame,controller);
            }
        });
        registrazioneDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrazioneDocente(mainFrame,controller);
            }
        });
        loginStudenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                try {
                    if(controller.loginStudente(login,password))
                        new ProfiloStudente(mainFrame, controller, login);
                } catch (CampoVuotoException | LoginException | MissingStudentException ex) {
                    JOptionPane.showMessageDialog(mainFrame,ex.getMessage());
                }
            }
        });

        loginDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                try {
                    if(controller.loginDocente(login,password))
                        new ProfiloDocente(mainFrame, controller, login);
                } catch (CampoVuotoException | LoginException | MissingTeacherException ex) {
                    JOptionPane.showMessageDialog(mainFrame,ex.getMessage());
                }

            }
        });
    }
}
