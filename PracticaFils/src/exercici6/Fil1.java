package exercici6;

import java.util.Random;

public class Fil1 extends Thread {
    private int nombreTotal;
    public volatile boolean running = true; // Variable per indicar si Fil1 està actiu

    public Fil1(int nombreTotal) {
        this.nombreTotal = nombreTotal;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < nombreTotal; i++) {
            System.out.println("Fil1: " + random.nextInt(100));
            try {
                Thread.sleep(1000); // Espera de 1 segon
            } catch (InterruptedException e) {
                System.out.println("Fil1 ha estat interromput.");
                return;
            }
        }
        running = false; // Indiquem que Fil1 ha acabat
    }
}
