## NomeApp
tool_dipendenti
ver. 1.0

## Descrizione
App Java per la gestione dei dipendenti

## Requisiti
- Java 17

## Installazione
1. Clona il repository  
2. Apri la cartela principale del progetto ed esegui a terminale il comandp 
    javac -d ../bin $(find . -name "*.java")
3. Crea il fle manifest.txt con il seguente contenuto per avviare l'app
    Main-Class: Avvio
4. Costruisci ed esegui il .jar
    jar cfm tool-dipendenti.jar manifest.txt -C bin 

## Uso
- Avvia il jar 
    jar cfm tool-dipendenti.jar manifest.txt -C bin .
- segui i comandi a terminale per inserire, modificare e visualizzare i dipendenti



## Licenza
FREE TO USE
