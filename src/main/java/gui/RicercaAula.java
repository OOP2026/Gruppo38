package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class RicercaAula {
    private JPanel mainPanel;
    private JButton indietroButton;
    private JButton profiloButton;
    private JButton logOutButton;
    private JList<String> auleList;
    private JPanel buttonPanel;
    private JLabel logoLabel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JComboBox<String> aulaComboBox;
    private DefaultListModel<String> modelloLista;
    private JFrame frame;

    public RicercaAula(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Aula");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ricercaFrame.setVisible(false);

        // Inizializzazione Lista
        modelloLista = new DefaultListModel<>();
        auleList.setModel(modelloLista);
        auleList.setFixedCellHeight(25);

        // Popolamento ComboBox Aule
        aulaComboBox.addItem("-SELECT-");
        for (String aula : controller.getNomiAule()) {
            aulaComboBox.addItem(aula);
        }

        // Listener per ricaricare quando si torna alla pagina
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                aggiornaDati("-SELECT-", controller);
            }
        });

        // Azione ComboBox
        aulaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String scelto = (String) aulaComboBox.getSelectedItem();
                aggiornaDati(scelto, controller);
            }
        });

        // Primo avvio
        aggiornaDati("-SELECT-", controller);

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
    private void aggiornaDati(String filtro, Controller controller) {
        modelloLista.clear();
        List<String> risultati = controller.getDatiAuleFormattati_Ricerca(filtro);
        if (risultati.isEmpty()) {
            modelloLista.addElement("Nessuna aula trovata.");
        } else {
            for (String r : risultati) modelloLista.addElement(r);
        }
    }
}
