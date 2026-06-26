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

public class ProfiloDocente {
    private JFrame profileFrame;
    private JPanel mainPanel;
    private JPanel logoPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JLabel logoLabel;
    private JPanel fieldPanel;
    private JPanel getPanel;
    private JButton insegnamentiButton;
    private JButton ricercaButton;
    private JButton modificaOrarioButton;
    private JLabel nomeLable;
    private JLabel cognomeLabel;
    private JLabel emailLabel;
    private JLabel responsabileLabel;
    private JLabel getNomeLabel;
    private JLabel getCognomeLabel;
    private JLabel getEmailLabel;
    private JLabel getResponsabileLabel;
    private JButton logOutButton;
    private JButton gestioneAuleButton;
    private BufferedImage logo;

    public ProfiloDocente (JFrame mainFrame, Controller controller, String login) {
        profileFrame = new JFrame("Profilo Docente");
        profileFrame.setContentPane(mainPanel);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(false);
        List<String> docente = controller.getAttributiDocente(login);

        getNomeLabel.setText(docente.get(0));
        getCognomeLabel.setText(docente.get(1));
        getEmailLabel.setText(docente.get(2));
        getResponsabileLabel.setText(docente.get(3));

        try {
            logo = ImageIO.read(new File("src/main/java/gui/image/fed2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logoLabel.setIcon(new ImageIcon(logo));

        if (!Boolean.parseBoolean(controller.getAttributiDocente(login).get(3))) {
            modificaOrarioButton.setToolTipText("Non sei Responsabile!");
            gestioneAuleButton.setToolTipText("Non sei Responsabile!");
            modificaOrarioButton.setEnabled(false);
            gestioneAuleButton.setEnabled(false);
        }

        profileFrame.pack();
        profileFrame.setVisible(true);
        profileFrame.setLocationRelativeTo(null);

        modificaOrarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new  ModificaOrario(profileFrame, controller);
            }
        });
        insegnamentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Insegnamenti(mainFrame, profileFrame,controller,login);
            }
        });
        ricercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FiltroRicerca(mainFrame, profileFrame,controller);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        gestioneAuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestioneAule(mainFrame, profileFrame, controller, login);
            }
        });
    }
}
