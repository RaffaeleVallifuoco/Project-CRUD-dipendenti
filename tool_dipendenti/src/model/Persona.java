package model;

import java.sql.Date;

public abstract class Persona {

    private int id;
    private String nome;
    private String cognome;
    private String cf;
    private String citta;
    private Date dataNascita;

    // CONSTRUCTORS

    public Persona() {
    }

    public Persona(int id, String nome, String cognome, String cf, String citta, Date dataNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.citta = citta;
        this.dataNascita = dataNascita;
    }

    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", citta=" + citta
                + ", dataNascita=" + dataNascita + "]";
    }

}
