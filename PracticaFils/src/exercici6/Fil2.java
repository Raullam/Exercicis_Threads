package exercici6;

import java.util.Random;

public class Fil2 extends Thread {
    private Fil1 fil1;

    public Fil2(Fil1 fil1) {
        this.fil1 = fil1;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            while (fil1.running) { // Mentre Fil1 estigui "en marxa"
                System.out.println("Fil2: " + random.nextInt(100));

                // Comprovem la variable running amb una espera més curta (100 ms)
                for (int i = 0; i < 10; i++) {
                    if (!fil1.running) break; // Comprovem si Fil1 ha acabat
                    Thread.sleep(100); // Espera de 100 ms (per assegurar que el fil comprova més sovint)
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Fil2 ha estat interromput.");
        }
    }
}
