package exercici2;

class Fil extends Thread {
    private int idFil;
    private int operacio; // 1 per sumar, -1 per restar
    static int[] compte = {0}; // Valor comú compartit entre els fils

    public Fil(int idFil, int operacio) {
        this.idFil = idFil;
        this.operacio = operacio;
    }

    @Override
    public void run() {
        synchronized (compte) {
            System.out.println("Fil " + (operacio == 1 ? "suma" : "resta") + " => compte: " + compte[0]); // Mostra el valor inicial de 'compte'

            // Pas 1: Guardar el valor comú 'compte' a un registre
            int registre = compte[0];
            registre += operacio * 10; // Suma o resta 10 segons l'operació

            System.out.println("Fil " + (operacio == 1 ? "suma" : "resta") + " => registre: " + registre); // Mostra el valor del registre

            // Pas 2: Assignar el valor del registre al valor comú 'compte'
            compte[0] = registre;

            System.out.println("Fil " + (operacio == 1 ? "suma" : "resta") + " => compte: " + compte[0]); // Mostra el nou valor de 'compte'
        }
    }
}