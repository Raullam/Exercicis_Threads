package exercici9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ContaVocals extends Thread {
    private String text;
    private char vocal;
    private Semaphore semafor;
    private String rutaArxiu;

    // Constructor que rep el text, la vocal a comptar, el semàfor i la ruta de l'arxiu
    public ContaVocals(String text, char vocal, Semaphore semafor, String rutaArxiu) {
        this.text = text;
        this.vocal = vocal;
        this.semafor = semafor;
        this.rutaArxiu = rutaArxiu;
    }

    // Mètode run() que es crida quan el fil comença a executar-se
    @Override
    public void run() {
        int contador = 0;

        // Comptar les aparicions de la vocal al text
        for (int i = 0; i < text.length(); i++) {
            if (Character.toLowerCase(text.charAt(i)) == vocal) {
                contador++;
            }
        }

        // Escritura a l'arxiu, utilitzant semàfor per evitar l'accés concurrent
        try {
            semafor.acquire();  // Obtenim el semàfor (només un fil pot escriure a l'arxiu a la vegada)
            try (FileWriter writer = new FileWriter(rutaArxiu, true)) {
                writer.write("La vocal '" + vocal + "' apareix " + contador + " vegades.\n");
            } catch (IOException e) {
                System.err.println("Error al escriure a l'arxiu: " + e.getMessage());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semafor.release();  // Alliberem el semàfor per a altres fils
        }
    }
}
