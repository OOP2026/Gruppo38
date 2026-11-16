package model;

import java.time.LocalTime;

public class Lezione {
    public Insegnamento getInsegnamento() {
        return insegnamento;
    }

    public void setInsegnamento(Insegnamento insegnamento) {
        this.insegnamento = insegnamento;
    }

    private Insegnamento insegnamento;
    private Aula aula;
    private GiornoSettimana giorno;
    private LocalTime oraInizio;
    private LocalTime oraFine;

    public Lezione(GiornoSettimana giorno, LocalTime oraInizio, LocalTime oraFine) {
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    public Lezione(Insegnamento insegnamento, Aula aula, LocalTime oraInizio, LocalTime oraFine) {
            this.insegnamento = insegnamento;
            this.aula = aula;
            this.oraInizio = oraInizio;
            this.oraFine = oraFine;
    }

    public GiornoSettimana getGiorno() {

        return giorno;
    }

    public void setGiorno(GiornoSettimana giorno) {

        this.giorno = giorno;
    }

    public LocalTime getOraInizio() {

        return oraInizio;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public LocalTime getOraFine() {

        return oraFine;
    }

    public void setOraFine(LocalTime oraFine) {

        this.oraFine = oraFine;
    }

    @Override
    public String toString() {
        return "Giorno: " + giorno + " | Orario: " + oraInizio + " | Orario: " + oraFine;
    }
}