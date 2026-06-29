package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GestioneAule {
    private JPanel mainPanel;
    private JList<String> auleList;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JButton creaAulaButton;
    private JButton modificaAulaButton;
    private JButton profiloButton;
    private JButton eliminaAulaButton;
    private JButton logOutButton;
    private JPanel aulaPanel;
    private JFrame gestioneFrame;
    private DefaultListModel<String> modelloLista;
    private String login;

    public GestioneAule(JFrame mainFrame, JFrame profileFrame, Controller controller, String login) {
        gestioneFrame = new JFrame("Gestione Aule");
        gestioneFrame.setContentPane(mainPanel);
        gestioneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(false);
        this.login = login;
        gestioneFrame.pack();
        gestioneFrame.setVisible(true);
        aulaPanel.setVisible(false);
        gestioneFrame.setLocationRelativeTo(null);

        modelloLista = new DefaultListModel<>();
        auleList.setModel(modelloLista);

        gestioneFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                aggiornaListaDati(controller);
                gestioneFrame.pack();
                gestioneFrame.setLocationRelativeTo(null);
            }
        });

        aggiornaListaDati(controller);

        creaAulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreaAula(gestioneFrame, controller, login);
            }
        });
        modificaAulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = auleList.getSelectedIndex();
                new ModificaAula(gestioneFrame, controller, selectedIndex);
            }
        });
        eliminaAulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = auleList.getSelectedIndex();
                if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler cancellare questo insegnamento?") == JOptionPane.YES_OPTION) {
                    controller.removeAula(selectedIndex);
                    aggiornaListaDati(controller);
                }
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                gestioneFrame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                profileFrame.dispose();
                gestioneFrame.dispose();
            }
        });
        auleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                modificaAulaButton.setEnabled(true);
                eliminaAulaButton.setEnabled(true);
            }
        });
    }
    private void aggiornaListaDati(Controller controller) {
        modelloLista.clear();

        modelloLista.addAll(controller.getAule());

        if (!modelloLista.isEmpty()) {
            aulaPanel.setVisible(true);
            modificaAulaButton.setEnabled(false);
            eliminaAulaButton.setEnabled(false);
        }  else {
            aulaPanel.setVisible(false);
        }
    }
}
