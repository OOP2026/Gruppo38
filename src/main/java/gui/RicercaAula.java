package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JTextField auleField;
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

        modelloLista = new DefaultListModel<>();
        auleList.setModel(modelloLista);
        auleList.setFixedCellHeight(25);

        auleField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                aggiornaDati(controller); // Scatta quando digiti/incolli una lettera
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                aggiornaDati(controller); // Scatta quando cancelli una lettera
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                aggiornaDati(controller); // Gestisce altri tipi di modifiche stilistiche
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                auleField.setText("");
                aggiornaDati(controller);
            }
        });

        aggiornaDati(controller);
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

    private void aggiornaDati(Controller controller) {
        String testoCercato = auleField.getText();
        modelloLista.clear();

        List<String> risultati = controller.getDatiAuleFormattati_Ricerca(testoCercato);

        if (risultati.isEmpty()) {
            modelloLista.addElement("Nessun risultato trovato.");
        } else {
            for (String r : risultati) {
                modelloLista.addElement(r);
            }
        }
    }
}