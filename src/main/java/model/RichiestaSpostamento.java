package model;

import java.time.LocalTime;

public class RichiestaSpostamento {
    private Lezione lezioneOriginale;
    private GiornoSettimana giornoProposto;
    private LocalTime oraInizioProposta;
    private LocalTime oraFineProposta;
    private StatoRichiesta stato;

    public RichiestaSpostamento(Lezione lezioneOriginale,
                                GiornoSettimana giornoProposto,
                                LocalTime oraInizioProposta,
                                LocalTime oraFineProposta,
                                StatoRichiesta stato) {
        this.lezioneOriginale = lezioneOriginale;
        this.giornoProposto = giornoProposto;
        this.oraInizioProposta = oraInizioProposta;
        this.oraFineProposta = oraFineProposta;
        this.stato = stato;
    }

    public RichiestaSpostamento(Lezione lezione, GiornoSettimana giorno, LocalTime oraInizio, LocalTime oraFine) {
    }

    public Lezione getLezioneOriginale() {
        return lezioneOriginale;
    }

    public void setLezioneOriginale(Lezione lezioneOriginale) {
        this.lezioneOriginale = lezioneOriginale;
    }

    public GiornoSettimana getGiornoProposto() {

        return giornoProposto;
    }

    public void setGiornoProposto(GiornoSettimana giornoProposto) {

        this.giornoProposto = giornoProposto;
    }

    public LocalTime getOraInizioProposta() {

        return oraInizioProposta;
    }

    public void setOraInizioProposta(LocalTime oraInizioProposta) {

        this.oraInizioProposta = oraInizioProposta;
    }

    public LocalTime getOraFineProposta() {

        return oraFineProposta;
    }

    public void setOraFineProposta(LocalTime oraFineProposta) {

        this.oraFineProposta = oraFineProposta;
    }

    public StatoRichiesta getStato() {

        return stato;
    }

    public void setStato(StatoRichiesta stato) {

        this.stato = stato;
    }
}
