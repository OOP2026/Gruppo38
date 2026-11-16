package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaOrario {
    private JPanel mainPanel;
    private JPanel tabellaOrariPanel;
    private JTable orariTable;
    private JButton tornaIndietroButton;
    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton richiesteSpostamentiButton;
    private JPanel richiestaSpostamentiPanel;
    private JFrame modificaOrarioFrame;

    public ModificaOrario(JFrame profileFrame, Controller controller, String login) {
        modificaOrarioFrame = new JFrame("Modifica Orario");
        modificaOrarioFrame.setContentPane(mainPanel);
        modificaOrarioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(false);

        String[] giorni = {"Orario", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì"};

        String[][] orari;
        String[][] orarioSalvato = controller.getOrarioGenerale();

        if (orarioSalvato != null) {
            orari = orarioSalvato;
        } else {
            orari = new String[][] {
                    {"08:00 - 09:00", "", "", "", "", ""},
                    {"09:00 - 10:00", "", "", "", "", ""},
                    {"10:00 - 11:00", "", "", "", "", ""},
                    {"11:00 - 12:00", "", "", "", "", ""},
                    {"12:00 - 13:00", "", "", "", "", ""}
            };
        }

        DefaultTableModel modello = new DefaultTableModel(orari, giorni) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        orariTable.setModel(modello);
        orariTable.getTableHeader().setResizingAllowed(false);
        orariTable.getTableHeader().setReorderingAllowed(false);

        JComboBox<String> comboInsegnamenti = new JComboBox<>();
        comboInsegnamenti.addItem("");
        for (String voce : controller.getTuttiInsegnamentiConDocente()) {
            comboInsegnamenti.addItem(voce);
        }

        JComboBox<String> comboAule = new JComboBox<>();
        comboAule.addItem("");

        for (String aula : controller.getNomiAule()) {
            comboAule.addItem(aula);
        }

        orariTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Boolean.parseBoolean(controller.getAttributiDocente(login).get(3))) {
                    if (e.getClickCount() == 2) {
                        int riga = orariTable.getSelectedRow();
                        int colonna = orariTable.getSelectedColumn();

                        if (colonna > 0) {
                            JPanel pannelloPopup = new JPanel(new GridLayout(0, 1));
                            pannelloPopup.add(new JLabel("Seleziona Insegnamento:"));
                            pannelloPopup.add(comboInsegnamenti);
                            pannelloPopup.add(new JLabel("Seleziona Aula:"));
                            pannelloPopup.add(comboAule);

                            int result = JOptionPane.showConfirmDialog(modificaOrarioFrame, pannelloPopup,
                                    "Assegna Lezione", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                            if (result == JOptionPane.OK_OPTION) {
                                String insSelezionato = (String) comboInsegnamenti.getSelectedItem();
                                String aulaSelezionata = (String) comboAule.getSelectedItem();

                                if (insSelezionato != null && !insSelezionato.isEmpty()) {
                                    String testoCella = insSelezionato;
                                    if (aulaSelezionata != null && !aulaSelezionata.trim().isEmpty()) {
                                        testoCella += " - " + aulaSelezionata;
                                    }
                                    orariTable.setValueAt(testoCella, riga, colonna);
                                } else {
                                    orariTable.setValueAt("", riga, colonna);
                                }
                            }
                        }
                    }
                }
                else JOptionPane.showMessageDialog(null,"Non sei responsabile!");
            }
        });

        modificaOrarioFrame.pack();
        modificaOrarioFrame.setVisible(true);
        modificaOrarioFrame.setLocationRelativeTo(null);

        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                modificaOrarioFrame.dispose();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int righe = orariTable.getRowCount();
                int colonne = orariTable.getColumnCount();
                String[][] datiDaSalvare = new String[righe][colonne];

                for (int r = 0; r < righe; r++) {
                    for (int c = 0; c < colonne; c++) {
                        Object valore = orariTable.getValueAt(r, c);
                        if(valore != null){
                            datiDaSalvare[r][c] = valore.toString();
                        } else {
                            datiDaSalvare[r][c] = "";
                        }
                    }
                }
                controller.salvaOrarioGenerale(datiDaSalvare);

                JOptionPane.showMessageDialog(modificaOrarioFrame, "Orario salvato correttamente!");
                profileFrame.setVisible(true);
                modificaOrarioFrame.dispose();
            }
        });
        richiesteSpostamentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RichiestaSpostamento(modificaOrarioFrame, controller, login);
            }
        });
    }
}