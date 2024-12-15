package exercici1;

import java.util.Random;

class Fil extends Thread {
    private int idFil;

    public Fil(int idFil) {
        this.idFil = idFil;
    }

    @Override
    public void run() {
        System.out.println("Fil " + idFil + ": iniciat"); // Mostra missatge d'inici
        
        // Genera i mostra un nombre aleatori entre 1 i 100
        Random random = new Random();
        int nombreAleatori = random.nextInt(100) + 1; // Nombre entre 1 i 100
        System.out.println("Fil " + idFil + ": valor " + nombreAleatori);
        
        System.out.println("Fil " + idFil + ": finalitzat"); // Mostra missatge de finalització
    }
}