package service;

public class Pause {

    public static void pausa(String messaggio, int millisecondi) {
        System.out.println(messaggio);
        try {
            Thread.sleep(millisecondi);
        } catch (InterruptedException e) {
            System.err.println("Pausa interrotta: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
