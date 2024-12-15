package exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControladorFils {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introdueix el nombre de fils (N): ");
            int N = scanner.nextInt(); // Demana el nombre de fils a crear
            
            Thread[] fils = new Thread[N];

            for (int i = 0; i < N; i++) { // Crea N fils
                fils[i] = new Fil(i + 1); // Crea un fil amb la classe 'Fil'
                fils[i].start(); // Inicia el fil
            }

            for (int i = 0; i < N; i++) { // Espera que tots els fils acabin
                fils[i].join();
            }
        } catch (InputMismatchException e) {
            System.out.println("Si us plau, introdueix un nombre enter vàlid.");
        } catch (InterruptedException e) {
            System.out.println("S'ha produït un error durant l'espera dels fils.");
        }
    }
}