package gui;

import controller.Controller;
import model.AnnoAccademico;
import model.Studente;

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
        frame = new JFrame("RegistrazioneStudente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        mainFrame.setVisible(false);
        frame.setVisible(true);

        primoRadioButton.setActionCommand(AnnoAccademico.PRIMO.name());
        secondoRadioButton.setActionCommand(AnnoAccademico.SECONDO.name());
        terzoRadioButton.setActionCommand(AnnoAccademico.TERZO.name());

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
                String selectedEnumStr = annoGroup.getSelection().getActionCommand();
                AnnoAccademico annoCorso = AnnoAccademico.valueOf(selectedEnumStr);

                Studente newStudente = new Studente(login, password, nome, cognome, email, matricola, annoCorso);

                mainFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}
