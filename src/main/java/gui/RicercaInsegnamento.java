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

public class RicercaInsegnamento {
    private JPanel mainPanel;
    private JButton indietroButton;
    private JButton profiloButton;
    private JButton logOutButton;
    private JTextField insegnamentoField;
    private JList<String> insegnamentoList;
    private JLabel logoPanel;
    private JPanel rightPanel;
    private JPanel buttonPanel;
    private JPanel leftPanel;
    private DefaultListModel<String> modelloLista;
    private JFrame frame;

    public RicercaInsegnamento(JFrame mainFrame, JFrame profileFrame, JFrame ricercaFrame, Controller controller) {
        frame = new JFrame("Ricerca Docente");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ricercaFrame.setVisible(false);

        modelloLista = new DefaultListModel<>();
        insegnamentoList.setModel(modelloLista);
        insegnamentoList.setFixedCellHeight(25);

        insegnamentoField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                aggiornaDati(controller);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                aggiornaDati(controller);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                aggiornaDati(controller);
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                insegnamentoField.setText("");
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
        String testoCercato = insegnamentoField.getText();
        modelloLista.clear();

        List<String> risultati = controller.getInsegnamentiFormattatiRicerca(testoCercato);

        if (risultati.isEmpty()) {
            modelloLista.addElement("Nessun risultato trovato.");
        } else {
            for (String r : risultati) {
                modelloLista.addElement(r);
            }
        }
    }
}