package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insegnamenti {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JList insegnamentiList;
    private JLabel ListaLabel;
    private JButton creaNuovoInsegnamentoButton;
    private JPanel buttonPanel;
    private JButton profiloButton;
    private JButton logOutButton;
    private JFrame frame;

    public Insegnamenti(JFrame mainFrame, JFrame profiloFrame, Controller controller, String login) {
        frame = new JFrame("Insegnamenti");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        creaNuovoInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfiloDocente(frame,controller,login);
                frame.dispose();
            }
        });
    }
}
