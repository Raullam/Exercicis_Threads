package exercici8;

public class Sumador extends Thread {
    private final Comptador comptador;
    private final int idFil;

    // Constructor per inicialitzar el fil amb el comptador i l'ID
    public Sumador(Comptador comptador, int idFil) {
        this.comptador = comptador;
        this.idFil = idFil;
    }

    @Override
    public void run() {
        // Obtenim el valor del comptador, l'incrementem i el mostrem
        int valorComptador = comptador.incrementa();

        try {
            Thread.sleep(500); // Espera per fer que els missatges es mostrin progressivament
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostrar el missatge amb el número de fil i el valor del comptador
        System.out.println("Fil " + idFil + ": el valor del comptador és " + valorComptador);
    }
}
