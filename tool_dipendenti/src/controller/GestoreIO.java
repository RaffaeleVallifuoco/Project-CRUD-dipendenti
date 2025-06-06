package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import model.Dipendente;
import model.Persona;

public class GestoreIO implements IGestoreIO {

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
            System.out.println("Input non valido");
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
            System.out.println("Input non valido");
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
            System.out.println("Input non valido");
            return leggiData(messaggio);
        }
    }

    @Override
    public void formRegistrazione(Persona dip) {
        String nome = leggiStringa("\nNome:\n");
        dip.setNome(nome);
        leggiStringa("\nCognome:\n");
        dip.setCognome(null);
        Date dataNascita = leggiData("\nData di nascita:\n");
        dip.setDataNascita(dataNascita);
        String cf = leggiStringa("\nCodice Fiscale:\n");
        dip.setCf(cf);
        String citta =leggiStringa("\nCitta di residenza:\n");
        dip.setCitta(citta);
        Double stipendio 0 leggiDecimale("\nStipendio:\n");
        if (dip instanceof Dipendente) {
            ((Dipendente) dip).setStipendio(stipendio);
}

    }

    @Override
    public Persona dupkica(Persona dipOriginale) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dupkica'");
    }

    @Override
    public void formModifica(Persona dipMModificato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formModifica'");
    }

    @Override
    public void schedaPersona(Persona dip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'schedaPersona'");
    }

    @Override
    public void visualizzaPersna(Map<Integer, Persona> db) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizzaPersna'");
    }

    @Override
    public void ceckOperazione(Boolean risultatoDML) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ceckOperazione'");
    }

}
