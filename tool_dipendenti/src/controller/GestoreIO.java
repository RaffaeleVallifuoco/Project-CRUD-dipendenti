package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import model.Dipendente;
import model.Persona;
import utility.Pause;
import utility.TerminalColor;

public class GestoreIO implements IGestoreIO {

    // aggiungo un metodo scanner() per evitare di dover ripetere ad ogni metodo di
    // inserimento la dichiarazone di un nuovo scanner.
    private Scanner scanner() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    @Override
    public String leggiStringa(String messaggio) {
        System.out.println(messaggio);
        String input = scanner().nextLine();
        return input;
    }

    @Override
    public int leggiIntero(String messaggio) {
        System.out.print(messaggio);
        String input = scanner().nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(TerminalColor.red("\nInput non valido\n"));
            return leggiIntero(messaggio);
        }
    }

    @Override
    public Double leggiDecimale(String messaggio) {
        System.out.print(messaggio);
        String input = scanner().nextLine();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println(TerminalColor.red("\nInput non valido\n"));
            return leggiDecimale(messaggio);
        }
    }

    @Override
    public Date leggiData(String messaggio) {
        System.out.print(messaggio);
        String input = scanner().nextLine();
        try {
            return Date.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println(TerminalColor.red("\nInput non valido\n"));
            return leggiData(messaggio);
        }
    }

    @Override
    public void formRegistrazione(Persona dip) {
        boolean check = true;
        String nome = leggiStringa(TerminalColor.cyan("\nNome:\n"));
        dip.setNome(nome);
        String cognome = leggiStringa(TerminalColor.cyan("\nCognome:\n"));
        dip.setCognome(cognome);
        do {
            try {
                Date dataNascita = leggiData(TerminalColor.cyan("\nData di nascita: (YYYY-MM-DD\n"));
                dip.setDataNascita(dataNascita);
                check = true;

            } catch (IllegalArgumentException e) {
                System.err.println(TerminalColor.red("Errore ! Formato data non valido. (YYYY-MM-DD)"));
                check = false;
            }
        } while (check == false);

        String cf = leggiStringa(TerminalColor.cyan("\nCodice Fiscale:\n"));
        dip.setCf(cf);
        String citta = leggiStringa(TerminalColor.cyan("\nCitta di residenza:\n"));
        dip.setCitta(citta);
        Double stipendio = leggiDecimale(TerminalColor.cyan("\nStipendio:\n"));
        if (dip instanceof Dipendente) {
            ((Dipendente) dip).setStipendio(stipendio);
        }
        Pause.pausa(TerminalColor.purple("\ninserimento dati in corso...\n", 1000));

    }

    @Override
    public void formModifica(Persona dipDuplicato) {
        boolean check = true;
        String nome = leggiStringa(TerminalColor.cyan("\nNome:\n"));
        dipDuplicato.setNome(nome);
        String cognome = leggiStringa(TerminalColor.cyan("\nCognome:\n"));
        dipDuplicato.setCognome(cognome);
        do {
            try {
                Date dataNascita = leggiData(TerminalColor.cyan("\nData di nascita: (YYYY-MM-DD)\n"));
                dipDuplicato.setDataNascita(dataNascita);
                check = true;

            } catch (IllegalArgumentException e) {
                System.err.println(TerminalColor.red("Errore ! Formato data non valido. (YYYY-MM-DD)"));
                check = false;
            }
        } while (check == false);

        String cf = leggiStringa(TerminalColor.cyan("\nCodice Fiscale:\n"));
        dipDuplicato.setCf(cf);
        String citta = leggiStringa(TerminalColor.cyan("\nCitta di residenza:\n"));
        dipDuplicato.setCitta(citta);
        Double stipendio = leggiDecimale(TerminalColor.cyan("\nStipendio:\n"));
        if (dipDuplicato instanceof Dipendente) {
            ((Dipendente) dipDuplicato).setStipendio(stipendio);
        }

    }

    @Override
    public Persona duplica(Persona dipOriginale) {
        Persona dipCopia = new Dipendente();
        Integer id = dipOriginale.getId();
        dipCopia.setId(id);
        String nome = dipOriginale.getNome();
        dipCopia.setNome(nome);
        String cognome = dipOriginale.getCognome();
        dipCopia.setCognome(cognome);
        Date dataDate = dipOriginale.getDataNascita();
        dipCopia.setDataNascita(dataDate);
        String cf = dipOriginale.getCf();
        dipCopia.setCf(cf);
        Double stipendio = null;
        if (dipOriginale instanceof Dipendente) {
            stipendio = ((Dipendente) dipOriginale).getStipendio();
        }
        ((Dipendente) dipCopia).setStipendio(stipendio);

        return dipCopia;

    }

    @Override
    public void schedaPersona(Persona dip) {
        Double stipendio = null;
        if (dip instanceof Dipendente) {
            stipendio = ((Dipendente) dip).getStipendio();
        }

        System.out.println("\n- Anagrafica dipendente -\n");
        System.out.println(String.format(
                "- Id: %d\n- Nome: %s\n- Cognome: %s\n- Data di nascita: %s\n- Codice fiscale: %s\n- Residenza: %s\n- Stipendio: %.2f\n",
                dip.getId(), dip.getNome(), dip.getCognome(), dip.getDataNascita(), dip.getCf(), dip.getCitta(),
                stipendio));

    }

    @Override
    public void visualizzaPersne(Map<Integer, Persona> db) {
        if (db.isEmpty()) {
            System.err.println(TerminalColor.red("\nNessun valore da mostarre\n"));
        }
        db.forEach((id, persona) -> {
            System.out.println("ID Chiave: " + id);
            schedaPersona(persona);
            System.out.println("\n--------------------------\n");
        });

    }

    @Override
    public void ceckOperazione(Boolean risultatoDML) {
        if (risultatoDML == true) {
            System.out.println(TerminalColor.green("\nOperazione effettuata con successo\n"));
        } else {
            System.err.println(TerminalColor.red("\nERRORE ! Operazione non riuscita\n"));
        }
    }

}
