package controller;

import java.sql.Date;
import java.util.Map;

import model.Persona;

public interface IGestoreIO {

    public String leggiStringa(String messaggio);

    public int leggiIntero(String messaggio);

    public Double leggiDecimale(String messaggio);

    public Date leggiData(String messaggio);

    public void formRegistrazione(Persona dip);

    public Persona duplica(Persona dipOriginale);

    public void formModifica(Persona dipMModificato);

    public void schedaPersona(Persona dip);

    public void visualizzaPersne(Map<Integer, Persona> db);

    public void ceckOperazione(Boolean risultatoDML);

}
