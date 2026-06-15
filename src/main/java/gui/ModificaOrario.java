package gui;

import controller.Controller;
import model.Insegnamento;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ModificaOrario {
    private JPanel mainPanel;
    private JTable orarioTable;
    private JList insegnamentiList;
    private JPanel tabellaOrariPanel;
    private JPanel listaInsegnamentiPanel;
    private JButton annullaButton;
    private JButton salvaButton;
    private DefaultListModel<String> modelloLista;
    private JFrame frame;
    private String login;

    public ModificaOrario (JFrame profileFrame, Controller controller, String login) {
        frame = new JFrame("Modifica Orario");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(false);
        this.login = login;
        frame.pack();
        frame.setVisible(true);

        TableModel dataModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return 10;
            }

            @Override
            public int getColumnCount() {
                return 7;
            }

            @Override
            public Object getValueAt(int row, int col) { return row * col; }
        };

        modelloLista = new DefaultListModel<>();
        insegnamentiList.setModel(modelloLista);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                aggiornaListaDati(controller);
            }
        });

        orarioTable = new JTable(dataModel);
        JScrollPane scrollPane = new JScrollPane(orarioTable);

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.setVisible(true);
                frame.dispose();
            }
        });
        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void aggiornaListaDati(Controller controller) {
        modelloLista.clear();

        modelloLista.addAll(controller.getInsegnamentiResponsabile(login));
    }
}
