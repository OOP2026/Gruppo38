package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RicercaAnno {
    private JPanel mainPanel;
    private JList<String> annoList;
    private JComboBox<String> annoComboBox;
    private JButton indietroButton;
    private JButton logOutButton;
    private JButton profiloButton;
    private JLabel logoLabel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel buttonPanel;
    private DefaultListModel<String> modelloLista;
    private JFrame frame;

    public RicercaAnno(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Anno");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ricercaFrame.setVisible(false);

        String[] anno = {"-SELECT-", "PRIMO", "SECONDO", "TERZO"};
        annoComboBox.setModel(new DefaultComboBoxModel<>(anno));

        modelloLista = new DefaultListModel<>();
        annoList.setModel(modelloLista);
        annoList.setFixedCellHeight(25);

        mostraTuttiGliInsegnamenti(controller);

        annoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String annoSelezionato = (String) annoComboBox.getSelectedItem();
                modelloLista.clear();

                if (annoSelezionato != null && !annoSelezionato.equals("-SELECT-")) {
                    List<String> risultati = controller.getInsegnamentiPerAnno(annoSelezionato);

                    if (risultati.isEmpty()) {
                        modelloLista.addElement("Nessun insegnamento trovato per il " + annoSelezionato + " anno.");
                    } else {
                        for (String risultato : risultati) {
                            modelloLista.addElement(risultato);
                        }
                    }
                } else {
                    mostraTuttiGliInsegnamenti(controller);
                }
            }
        });

        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ricercaFrame.setVisible(true);
                frame.dispose();
            }
        });
        profiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                frame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(true);
                frame.dispose();
            }
        });
    }

    private void mostraTuttiGliInsegnamenti(Controller controller) {
        modelloLista.clear();
        List<String> tutti = controller.getInsegnamentiPerRicercaAnno();

        if (tutti.isEmpty()) {
            modelloLista.addElement("Nessun insegnamento registrato nel sistema.");
        } else {
            for (String voce : tutti) {
                modelloLista.addElement(voce);
            }
        }
    }
}