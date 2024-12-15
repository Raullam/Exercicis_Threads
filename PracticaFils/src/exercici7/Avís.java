package exercici7;

public class Avís extends Thread {
    private CompteEnrere compteEnrere;

    public Avís(CompteEnrere compteEnrere) {
        this.compteEnrere = compteEnrere;
    }

    @Override
    public void run() {
        int tempsInicial = compteEnrere.getTempsRestant();
        boolean avis34 = false, avis50 = false, avis25 = false;

        while (true) {
            int tempsRestant = compteEnrere.getTempsRestant();

            synchronized (compteEnrere) {
                if (tempsRestant <= 0) break; // Finalitzar si no hi ha temps restant

                // Mostrar avisos només una vegada
                if (!avis34 && tempsRestant == tempsInicial * 3 / 4) {
                    System.out.println("Queda 3/4 del temps.");
                    avis34 = true;
                } else if (!avis50 && tempsRestant == tempsInicial / 2) {
                    System.out.println("Queda la meitat del temps.");
                    avis50 = true;
                } else if (!avis25 && tempsRestant == tempsInicial / 4) {
                    System.out.println("Queda 1/4 del temps.");
                    avis25 = true;
                }
            }

            try {
                Thread.sleep(500); // Comprova cada 500 ms
            } catch (InterruptedException e) {
                System.out.println("Fil avís interromput.");
                break;
            }
        }

        System.out.println("TIME OUT"); // Mostra TIME OUT quan acaba
    }
}
