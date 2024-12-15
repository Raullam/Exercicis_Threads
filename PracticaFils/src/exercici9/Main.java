package exercici9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        // Creem un semàfor per controlar l'accés concurrent a l'arxiu
        Semaphore semaphore = new Semaphore(1);

        // Demanem al usuari el text i la ruta de l'arxiu
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el text: ");
        String text = scanner.nextLine();
        System.out.print("Introdueix la ruta de l'arxiu per escriure els resultats: ");
        String rutaArxiu = scanner.nextLine();
        scanner.close();

        // Creem i iniciem els fils per cada vocal
        Thread[] fils = new Thread[5];
        char[] vocals = {'a', 'e', 'i', 'o', 'u'};

        // Creem o sobreescrivim l'arxiu amb la informació de la compta de vocals
        try {
            File file = new File(rutaArxiu);
            if (file.exists()) {
                file.delete();  // Si l'arxiu existeix, el suprimim per començar de nou
            }
            file.createNewFile();  // Creem l'arxiu si no existeix
        } catch (IOException e) {
            System.err.println("Error al crear l'arxiu: " + e.getMessage());
            return;
        }

        // Creem un fil per cada vocal
        for (int i = 0; i < 5; i++) {
            fils[i] = new ContaVocals(text, vocals[i], semaphore, rutaArxiu);
            fils[i].start();
        }

        // Esperem que tots els fils acabin la seva execució
        try {
            for (int i = 0; i < 5; i++) {
                fils[i].join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Missatge final
        System.out.println("Programa finalitzat. Els resultats s'han escrit a l'arxiu.");

        // Llegim el contingut de l'arxiu i el mostrem a la pantalla
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArxiu))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error al llegir l'arxiu: " + e.getMessage());
        }
    }
}
