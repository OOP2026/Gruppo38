package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Insegnamenti {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JList<String> insegnamentiList;
    private JLabel listaLabel;
    private JButton creaNuovoInsegnamentoButton;
    private JPanel buttonPanel;
    private JButton profiloButton;
    private JButton logOutButton;
    private JButton cancellaInsegnamentoButton;
    private JButton modificaInsegnamentoButton;
    private JFrame insegnamentoFrame;
    private DefaultListModel<String> modelloLista;
    private String login;

    public Insegnamenti(JFrame mainFrame, JFrame profileFrame, Controller controller, String login) {
        insegnamentoFrame = new JFrame("Insegnamenti");
        insegnamentoFrame.setContentPane(mainPanel);
        insegnamentoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insegnamentoFrame.pack();
        profileFrame.setVisible(false);
        this.login = login;
        insegnamentoFrame.setVisible(true);
        modificaInsegnamentoButton.setVisible(false);
        cancellaInsegnamentoButton.setVisible(false);
        insegnamentoFrame.setLocationRelativeTo(null);

        modelloLista = new DefaultListModel<>();
        insegnamentiList.setModel(modelloLista);

        insegnamentoFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                aggiornaListaDati(controller);
                insegnamentoFrame.pack();
                insegnamentoFrame.setLocationRelativeTo(null);
            }
        });

        aggiornaListaDati(controller);

        creaNuovoInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreaIns(insegnamentoFrame, controller, login);
                insegnamentoFrame.dispose();
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                insegnamentoFrame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                profileFrame.dispose();
                insegnamentoFrame.dispose();
            }
        });
        insegnamentiList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                modificaInsegnamentoButton.setEnabled(true);
                cancellaInsegnamentoButton.setEnabled(true);
            }
        });
        cancellaInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = insegnamentiList.getSelectedIndex();
                if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler cancellare questo insegnamento?") == JOptionPane.YES_OPTION) {
                    controller.removeInsegnamento(login, selectedIndex);
                    aggiornaListaDati(controller);
                }
            }
        });
        modificaInsegnamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = insegnamentiList.getSelectedIndex();
                new ModificaInsegnamento(insegnamentoFrame, controller, login, selectedIndex);
            }
        });
    }

    private void aggiornaListaDati(Controller controller) {
        modelloLista.clear();

        modelloLista.addAll(controller.getInsegnamenti(login));

        if (!modelloLista.isEmpty()) {
            modificaInsegnamentoButton.setVisible(true);
            modificaInsegnamentoButton.setEnabled(false);
            cancellaInsegnamentoButton.setVisible(true);
            cancellaInsegnamentoButton.setEnabled(false);
        }  else {
            modificaInsegnamentoButton.setVisible(false);
            cancellaInsegnamentoButton.setVisible(false);
        }
    }
}
