package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaOrario {
    private JPanel mainPanel;
    private JPanel tabellaOrariPanel;
    private JTable orariTable;
    private JButton tornaIndietroButton;
    private JPanel burronPanel;
    private DefaultListModel<String> modelloLista;
    private JFrame frame;
    private String login;

    public ModificaOrario (JFrame profileFrame, Controller controller, String login) {
        frame = new JFrame("Modifica Orario");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(false);
        this.login = login;
        frame.setLocationRelativeTo(null);

        String[] giorni = {"Orario", "Lunedì", "Marted'","Mercoledì","Giovedì","Venerdì"};

        String[][] orari = {
                {"08:00 - 09:00", "", "", "", "", ""},
                {"09:00 - 10:00", "", "", "", "", ""},
                {"10:00 - 11:00", "", "", "", "", ""},
                {"11:00 - 12:00", "", "", "", "", ""},
                {"12:00 - 13:00", "", "", "", "", ""}
        };

        DefaultTableModel modello = new DefaultTableModel(orari, giorni) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        orariTable.setModel(modello);
        orariTable.getTableHeader().setResizingAllowed(false);
        orariTable.getTableHeader().setReorderingAllowed(false);

        frame.pack();
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                frame.dispose();
            }
        });
    }
}