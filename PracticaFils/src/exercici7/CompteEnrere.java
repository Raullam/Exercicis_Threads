package exercici7;

public class CompteEnrere extends Thread {
    private int temps;

    public CompteEnrere(int temps) {
        this.temps = temps;
    }

    @Override
    public void run() {
        System.out.println("Començem el compte enrere");

        while (true) {
            synchronized (this) {
                if (temps <= 0) break; // Acaba quan temps arriba a 0
                System.out.println(temps); // Mostra el temps actual
                temps--; // Decrement sincronitzat
            }

            try {
                Thread.sleep(1000); // Espera d'un segon
            } catch (InterruptedException e) {
                System.out.println("Fil compte enrere interromput.");
                break;
            }
        }
    }

    public synchronized int getTempsRestant() {
        return temps; // Retorna el temps restant sincronitzadament
    }
}
