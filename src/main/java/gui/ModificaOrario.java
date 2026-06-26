package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModificaOrario {
    private JPanel mainPanel;
    private JPanel tabellaOrariPanel;
    private JTable orariTable;
    private JButton tornaIndietroButton;
    private JPanel buttonPanel;
    private JButton saveButton;
    private JFrame frame;

    public ModificaOrario (JFrame profileFrame, Controller controller) {
        frame = new JFrame("Modifica Orario");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(false);

        String[] giorni = {"Orario", "Lunedì", "Martedì","Mercoledì","Giovedì","Venerdì"};

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
                return column != 0;
            }
        };

        orariTable.setModel(modello);
        orariTable.getTableHeader().setResizingAllowed(false);
        orariTable.getTableHeader().setReorderingAllowed(false);

        JComboBox<String> comboInsegnamenti = new JComboBox<>();
        comboInsegnamenti.addItem("");

        List<String> listaInsegnamenti = controller.getTuttiInsegnamentiConDocente();
        for (String voce : listaInsegnamenti) {
            comboInsegnamenti.addItem(voce);
        }

        for (int i = 1; i < orariTable.getColumnCount(); i++) {
            orariTable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(comboInsegnamenti));
        }

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                frame.dispose();
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

                JOptionPane.showMessageDialog(frame, "Orario salvato correttamente!");
                profileFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}