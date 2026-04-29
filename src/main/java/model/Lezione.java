package model;

import java.time.LocalTime;

public class Lezione {
    private GiornoSettimana giorno;
    private LocalTime oraInizio;
    private LocalTime oraFine;

    public Lezione(GiornoSettimana giorno, LocalTime oraInizio, LocalTime oraFine) {
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    public Lezione(Insegnamento insegnamento, Aula aula, LocalTime oraInizio, LocalTime oraFine) {
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