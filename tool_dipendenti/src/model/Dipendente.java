package model;

import java.sql.Date;

public class Dipendente extends Persona {

    private Double stipendio;

    // CONSTRUCTORS

    public Dipendente() {
        super();
    }

    public Dipendente(int id, String nome, String cognome, String cf, String citta, Date dataNascita,
            Double stipendio) {
        super(id, nome, cognome, cf, citta, dataNascita);
        this.stipendio = stipendio;
    }

    // GETTERS & SETTERS

    public Double getStipendio() {
        return stipendio;
    }

    public void setStipendio(Double stipendio) {
        this.stipendio = stipendio;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Dipendente [stipendio=" + stipendio + "]";
    }

}
