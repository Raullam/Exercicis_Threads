package exercici5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Demanar a l'usuari quantes vegades vol mostrar "TIC TAC"
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantes vegades vols veure 'TIC TAC'? ");
        int n = scanner.nextInt();
        scanner.close();

        // Crear un nombre de fils igual a 'n' per a "TIC" i "TAC"
        Thread[] fils = new Thread[2 * n];  // Es necessiten 2 fils per cada "TIC TAC" (un per TIC i un per TAC)

        // Crear i iniciar els fils per mostrar "TIC" i "TAC"
        for (int i = 0; i < n; i++) {
            fils[2 * i] = new TicToc("TIC");
            fils[2 * i + 1] = new TicToc("TAC");

            fils[2 * i].start();  // Iniciar el fil "TIC"
            fils[2 * i + 1].start();  // Iniciar el fil "TAC"
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
