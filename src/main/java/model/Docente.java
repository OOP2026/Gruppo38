package model;

import exceptions.CampoVuotoException;

import java.time.LocalTime;
import java.util.ArrayList;

public class Docente extends Utente {
    private Boolean isResponsabile;
    private ArrayList<Insegnamento> materie;
    private ArrayList<Vincolo> vincoli;
    private ArrayList<Lezione> lezioni;
    private ArrayList<RichiestaSpostamento> richieste;

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

    public Boolean isResponsabile() {
        return isResponsabile;
    }

    public void setResponsabile(boolean responsabile) {
        isResponsabile = responsabile;
    }

    public ArrayList<Insegnamento> getMaterie() {
        return materie;
    }

    public void aggiungiMateria (String nome, String cfuStr, String annoCorsoStr) throws CampoVuotoException, NumberFormatException {

        if (nome.isBlank() || cfuStr.isBlank() || annoCorsoStr.equals("-SELECT-")) {
            throw new CampoVuotoException("Bisogna riempire tutti i campi!");
        }

        int cfu = Integer.parseInt(cfuStr.trim());

        AnnoAccademico annoCorso =  AnnoAccademico.valueOf(annoCorsoStr);
        materie.add(new Insegnamento(nome, cfu, annoCorso));
    }

    public ArrayList<Vincolo> getVincoli() {
        return vincoli;
    }

    public void setVincoli(ArrayList<Vincolo> vincoli) {
        this.vincoli = vincoli;
    }

}
