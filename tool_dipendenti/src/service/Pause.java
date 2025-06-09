package service;

public class Pause {

    public static void pausa(String messaggio, int secondi) {
        System.out.println(messaggio);
        try {
            Thread.sleep(secondi * 1000);
        } catch (InterruptedException e) {
            System.err.println("Pausa interrotta: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
