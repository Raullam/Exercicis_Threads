package exercici6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Demanar al usuari quants nombres vol mostrar Fil1
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la quantitat de nombres aleatoris: ");
        int n = scanner.nextInt();
        scanner.close();

        // Crear els fils
        Fil1 fil1 = new Fil1(n);
        Fil2 fil2 = new Fil2(fil1);

        // Iniciar els fils
        fil1.start();
        fil2.start();

        // Esperar que tots els fils acabin
        try {
            fil1.join();  // Esperar que Fil1 acabi
            fil2.join();  // Esperar que Fil2 acabi
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostrar missatge final
        System.out.println("Programa finalitzat");
    }
}
