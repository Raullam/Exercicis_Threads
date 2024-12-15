package exercici5b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Demanar a l'usuari quantes vegades vol mostrar "TIC TAC"
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Quantes vegades vols veure 'TIC TAC'? ");
        int n = scanner.nextInt();
        scanner.close();

        // Crear una llista de fils
        List<Thread> fils = new ArrayList<>();

        // Crear els fils per a "TIC" i "TAC"
        for (int i = 0; i < n; i++) {
            fils.add(new TicToc("TIC"));
            fils.add(new TicToc("TAC"));
        }

        // Barrejant aleatòriament els fils perquè es mostrin en ordre aleatori
        Collections.shuffle(fils);

        // Iniciar els fils
        for (Thread fil : fils) {
            fil.start();
        }

        // Esperar que tots els fils acabin
        try {
            for (Thread fil : fils) {
                fil.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostrar el missatge de finalització
        System.out.println("Programa finalitzat");
    }
}
