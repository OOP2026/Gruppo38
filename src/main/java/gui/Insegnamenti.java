package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class Insegnamenti {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JList<String> insegnamentiList;
    private JLabel ListaLabel;
    private JButton creaNuovoInsegnamentoButton;
    private JPanel buttonPanel;
    private JButton profiloButton;
    private JButton logOutButton;
    private JFrame insegnamentoFrame;
    private DefaultListModel<String> modelloLista;

    public Insegnamenti(JFrame mainFrame, JFrame profileFrame, Controller controller, String login) {
        insegnamentoFrame = new JFrame("Insegnamenti");
        insegnamentoFrame.setContentPane(mainPanel);
        insegnamentoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insegnamentoFrame.pack();
        profileFrame.setVisible(false);
        insegnamentoFrame.setVisible(true);

        modelloLista = new DefaultListModel<>();
        insegnamentiList.setModel(modelloLista);

        insegnamentoFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                aggiornaListaDati(controller);
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
                insegnamentoFrame.dispose();
                profileFrame.setVisible(true);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.dispose();
                insegnamentoFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
    }

    private void aggiornaListaDati(Controller controller) {
        modelloLista.clear();

        List<String> datiInsegnamenti = controller.getInsegnamentiFormattati();

        if (datiInsegnamenti != null) {
            for (String riga : datiInsegnamenti) {
                modelloLista.addElement(riga);
            }
        }
    }
}
