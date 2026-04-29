package model;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class Docente extends Utente {
    private boolean isResponsabile;
    private List<Insegnamento> materie;
    private List<Vincolo> vincoli;
    private List<Lezione> lezioni;
    private List<RichiestaSpostamento> richieste;
    //private List<Aula> aule;//

    public Docente(String login, String password, String nome,
                   String cognome, String email, boolean isResponsabile) {
        super(login, password, nome, cognome, email);
        this.isResponsabile = isResponsabile;
        this.materie = new ArrayList<>();
        this.vincoli = new ArrayList<>();
        this.lezioni = new ArrayList<>();
        this.richieste = new ArrayList<>();
    }

    public void visualizzaOrario() {
        System.out.println("Orario del Docente");
        if (lezioni.isEmpty()) {
            System.out.println("Nessuna lezione programmata.");
        } else {
            for (Lezione l : this.lezioni) {
                System.out.println("Lezione: " + l.toString());
            }
        }
    }
    public void richiediSpostamento(Lezione lezione, GiornoSettimana giorno, LocalTime oraInizio, LocalTime oraFine) {
        RichiestaSpostamento nuovaRichiesta = new RichiestaSpostamento(lezione, giorno, oraInizio, oraFine);
        this.richieste.add(nuovaRichiesta);
        System.out.println("Richiesta inviata per la lezione: " + lezione);
    }
    public void aggiungiVincolo(Vincolo vincolo) {
        if (this.vincoli.size() < 3) {
            this.vincoli.add(vincolo);
        } else {
            System.out.println("Hai già raggiunto il limite di 3 vincoli!");
        }
    }
    public void creaLezione(Insegnamento insegnamento, Aula aula, LocalTime oraInizio, LocalTime oraFine) {
        Lezione nuovaLezione = new Lezione(insegnamento, aula, oraInizio, oraFine);
        this.lezioni.add(nuovaLezione);
        System.out.println("Lezione creata per: " + insegnamento);
    }
    public void inserisciAula(String nomeAula) {

        System.out.println("Aula " + nomeAula + " registrata nel sistema.");
    }
    public void gestisciRichieste(RichiestaSpostamento richiesta, boolean esito) {
        if (esito) {
            richiesta.setStato(StatoRichiesta.APPROVATA);
        } else {
            richiesta.setStato(StatoRichiesta.RIFIUTATA);
        }
        System.out.println("Richiestagestita.");
    }

    public boolean isResponsabile() {
        return isResponsabile;
    }

    public void setResponsabile(boolean responsabile) {
        isResponsabile = responsabile;
    }

    public List<Insegnamento> getMaterie() {
        return materie;
    }

    public void setMaterie(List<Insegnamento> materie) {
        this.materie = materie;
    }

    public List<Vincolo> getVincoli() {
        return vincoli;
    }

    public void setVincoli(List<Vincolo> vincoli) {
        this.vincoli = vincoli;
    }

}
