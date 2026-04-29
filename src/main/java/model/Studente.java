package model;

import java.util.List;
import java.util.ArrayList;

public class Studente extends Utente{
    private String matricola;
    private AnnoAccademico annoCorso;
    private List<Lezione> lezioni;

    public Studente(String login, String password, String nome,
                    String cognome, String email, String matricola, AnnoAccademico annoCorso) {
        super(login, password, nome, cognome, email);
        this.matricola = matricola;
        this.annoCorso = annoCorso;
        this.lezioni = new ArrayList<>();
    }
    public List<Lezione> visualizzaOrario(){
        if (this.lezioni.isEmpty()) {
            System.out.println("Nessuna lezione presente per lo studente " + getNome());
        } else {
            System.out.println("Orario lezioni");
            for (Lezione lezione : this.lezioni) {
                System.out.println(lezione.toString());
            }
        }
        return this.lezioni;
    }
    public void aggiungiLezione(Lezione lezione) {
        if (lezione != null) {
            this.lezioni.add(lezione);
        }
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public AnnoAccademico getAnnoCorso() {
        return annoCorso;
    }

    public void setAnnoCorso(AnnoAccademico annoCorso) {
        this.annoCorso = annoCorso;
    }
}
