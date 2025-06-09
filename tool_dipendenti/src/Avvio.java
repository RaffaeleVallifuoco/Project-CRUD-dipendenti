import java.util.logging.LogRecord;

import controller.GestoreIO;
import model.Dipendente;
import model.Persona;
import service.Logo;
import service.Pause;
import service.TerminalColor;
import view.CrudService;

public class Avvio {
    public static void main(String[] args) throws Exception {

        System.out.println("\n\n");

        Logo.printMenuLogo();

        // global var.
        boolean loop = true;
        GestoreIO gio = new GestoreIO();
        CrudService crs = new CrudService();

        // loop menu

        do {

            Persona dip = new Dipendente();
            int risposta = 0;

            // try-catch per gestione eccezione generica
            try {
                System.err.println(TerminalColor.blue("\n- MENU -\n"));

                risposta = gio.leggiIntero(
                        "1. Visualizza lista dipendenti\n2. Cerca dipendente\n3. inserisci un nuovo dipendente al database\n4. Modifica un dipendente esistente\n5. Rimuovi un dipendente dal database\n\n0. Esci dal programma\n\n\n");

                switch (risposta) {
                    // findAll
                    case 1 -> {
                        Pause.pausa("\n recpero i dati...", 1000);
                        crs.leggi();
                        break;
                    }
                    // findById
                    case 2 -> {
                        Pause.pausa("\n", 200);
                        Integer id = gio.leggiIntero("\nInserisci l'id dell'utente da ricercare :\n");
                        Pause.pausa("\n recpero i dati...", 1000);
                        crs.leggi(id);
                        break;
                    }
                    // insert
                    case 3 -> {
                        crs.inserisciPersona(dip);
                        break;
                    }
                    // update
                    case 4 -> {
                        Integer id = gio.leggiIntero("\nInserisci l'id dell'utente da modificare :\n");
                        Persona dipModifica = crs.leggi(id);
                        gio.ceckOperazione(crs.modificaPersona(dipModifica));
                        break;
                    }
                    // delete
                    case 5 -> {
                        Integer id = gio.leggiIntero("\nInserisci l'id dell'utente da rimuovere :\n");
                        gio.ceckOperazione(crs.rimuoviPersona(id));

                        break;
                    }
                    case 0 -> {
                        System.out.println("\nUscita in corso ...\n");
                        loop = false;
                        break;

                    }
                    // default
                    default -> {
                        gio.ceckOperazione(false);
                        break;
                    }
                }

                // resetto la variabile risponsta per evitare errori
                risposta = 0;

                // ripeto ciclo o esco
                if (loop == true) {
                    risposta = gio
                            .leggiIntero(
                                    "\nCosa vuoi fare ora :\n\n1. Torna al menu principale\n2. Esci dal programma\n");

                    switch (risposta) {
                        case 1 -> {
                            loop = true;
                            break;
                        }
                        default -> {
                            System.out.println("\nUscita in corso ...\n");
                            loop = false;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                gio.ceckOperazione(false);
                loop = true;
            }
        } while (loop == true);

    }

}
