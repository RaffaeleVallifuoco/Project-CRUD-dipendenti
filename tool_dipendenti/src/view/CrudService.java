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
        \     if (dip != null) {
                Persona dipCopia = gio.duplica(dip);
                System.out.println("\nDATI ATTUALI:\n");
                gio.schedaPersona(dip);
                System.out.println("\nMODIFICA I DATI:\n");
                gio.formModifica(dipCopia);
                String choice = gio.leggiStringa("\nVUOI SALVARE LE MODIFICHE ? (s/n)\n");
                switch (choice.toLowerCase()) {
                    case "s" -> {
                        gio.ceckOperazione(true);
                        db.put(dipCopia.getId(), dipCopia);
                        break;
                    }
                    case "n" -> {
                        gio.ceckOperazione(false);
                        break;
                    }
                    default:
                        gio.ceckOperazione(false);
                        break;
                }

            } else {
                System.err.println("\nId non presente a db\n");
                return false;
            }
        }

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
