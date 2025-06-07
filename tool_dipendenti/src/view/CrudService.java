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
            gio.formRegistrazione(dip);
            dip.setId(idAutoIncrement);
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
        if (dip != null) {
            Persona dipCopia = gio.duplica(dip);
            System.out.println("\nDATI ATTUALI:\n");
            gio.schedaPersona(dip);
            System.out.println("\nMODIFICA I DATI:\n");
            gio.formModifica(dipCopia);
            String choice = gio.leggiStringa("\nVUOI SALVARE LE MODIFICHE ? (s/n)\n");
            switch (choice.toLowerCase()) {
                case "s" -> {
                    db.put(dipCopia.getId(), dipCopia);
                    return true;
                }
                case "n" -> {
                    return false;
                }
                default -> {
                    return false;
                }
            }
        } else {
            System.err.println("\nId non presente a db\n");
            return false;
        }
    }

    @Override
    public boolean rimuoviPersona(Integer id) {
        if (db.get(id) != null) {
            db.remove(id);
            return true;
        } else {
            System.err.println("\nId non presente a db\n");
            return false;
        }
    }

    @Override
    public Persona leggi(int id) {
        System.out.println("\n- Risultato ricerca :\n");
        Persona persona = db.get(id);
        if (persona != null) {
            gio.schedaPersona(persona);
        } else {
            System.err.println("\nId non presente a db\n");
        }
        return persona;
    }

    @Override
    public Map<Integer, Persona> leggi() {
        System.out.println("\n- Lista dipendenti :\n");
        gio.visualizzaPersne(db);
        return db;
    }

}
