package view;

import java.util.HashMap;
import java.util.Map;

import model.Persona;
import controller.GestoreIO;

public class CrudService implements ICrudService {

    GestoreIO gio = new GestoreIO();
    int idAutoIncrement = 1;
    Map<Integer, Persona> db = new HashMap<>();

    @Override
    public boolean inserisciPersona(Persona dip) {

        if (db.get(dip.getId()) == null) {
            db.put(idAutoIncrement, dip);
            idAutoIncrement++;
            return true;
        } else {
            System.err.println("\nId gia presente a database\n");
            return false;
        }
    }

    @Override
    public boolean modificaPersona(Persona dip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificaPersona'");
    }

    @Override
    public boolean rimuoviPersona(Persona dip) {
        if (db.get(dip.getId()) != null) {
            db.remove(dip.getId());
            return true;
        } else {
            System.err.println("\nId non presente a db\n");
            return false;
        }
    }

    @Override
    public Persona leggi(int id) {
        return db.get(id);
    }

    @Override
    public Map<Integer, Persona> leggi() {
        return db;
    }

}
