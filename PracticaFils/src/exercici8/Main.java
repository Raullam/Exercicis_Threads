package exercici8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Demanar a l'usuari el nombre de fils a crear
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nombre de fils Sumador a crear: ");
        int nombreFils = scanner.nextInt();
        scanner.close();

        // Crear el comptador compartit
        Comptador comptador = new Comptador();

        // Crear i iniciar els fils
        Thread[] fils = new Thread[nombreFils];
        for (int i = 0; i < nombreFils; i++) {
            fils[i] = new Sumador(comptador, i + 1); // A cada fil li assignem un ID
            fils[i].start();
        }

        // Esperar que tots els fils acabin
        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Mostrar el missatge final
        System.out.println("Programa finalitzat");
    }
}
