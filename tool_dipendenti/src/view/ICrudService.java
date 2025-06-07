package view;

import java.util.Map;

import model.Persona;

public interface ICrudService {

    public boolean inserisciPersona(Persona dip);

    public boolean modificaPersona(Persona dip);

    public boolean rimuoviPersona(Integer id);

    public Persona leggi(int id);

    public Map<Integer, Persona> leggi();

}
