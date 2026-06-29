package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class RicercaDocente {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel buttonPanel;
    private JButton indietroButton;
    private JButton profiloButton;
    private JButton logOutButton;
    private JLabel logoLabel;
    private JTextField docentiField;
    private JList<String> docentiList;
    private JFrame frame;

    public RicercaDocente(Frame mainFrame, Frame profileFrame, Frame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Docente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
