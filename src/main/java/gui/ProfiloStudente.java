package gui;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProfiloStudente {

    private JFrame profileFrame;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JLabel matricolaLabel;
    private JLabel emailLabel;
    private JLabel annoCorsoLabel;
    private JPanel fieldPanel;
    private JPanel getPanel;
    private JButton ricercaButton;
    private JLabel getNomeLabel;
    private JLabel getCognomeLabel;
    private JLabel getMatricolaLabel;
    private JLabel getEmailLabel;
    private JLabel getAnnoCorsoLabel;
    private JPanel logoPanel;
    private JLabel logoLabel;
    private JButton logOutButton;
    private BufferedImage logo;

    public ProfiloStudente (JFrame mainFrame, Controller controller, String login) {
        profileFrame = new JFrame("Profilo Studente");
        profileFrame.setContentPane(mainPanel);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(false);
        List<String> studente = controller.getAttributiStudente(login);

        getNomeLabel.setText(studente.get(0));
        getCognomeLabel.setText(studente.get(1));
        getMatricolaLabel.setText(studente.get(2));
        getEmailLabel.setText(studente.get(3));
        getAnnoCorsoLabel.setText(studente.get(4));

        try {
            logo = ImageIO.read(new File("src/main/java/gui/image/fed2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logoLabel.setIcon(new ImageIcon(logo));

        profileFrame.pack();
        profileFrame.setVisible(true);

        ricercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ricerca(mainFrame, profileFrame,controller);
                profileFrame.setVisible(false);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
    }
}
