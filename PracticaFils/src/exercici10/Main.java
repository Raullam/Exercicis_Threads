package exercici10;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int repetitions = 5;  // Nombre de vegades que es vol mostrar la seqüència TIC TAC TOC
        Semaphore semaphoreTic = new Semaphore(1);  // Semàfor per TIC
        Semaphore semaphoreTac = new Semaphore(0);  // Semàfor per TAC
        Semaphore semaphoreToc = new Semaphore(0);  // Semàfor per TOC

        // Creem els fils per mostrar TIC, TAC i TOC, repetits per N vegades
        for (int i = 0; i < repetitions; i++) {
            // Crear i iniciar els fils
            new TicTacToc("TIC", semaphoreTic, semaphoreTac).start();
            new TicTacToc("TAC", semaphoreTac, semaphoreToc).start();
            new TicTacToc("TOC", semaphoreToc, semaphoreTic).start();
        }

        // Missatge final del fil principal
        try {
            // Esperem un temps per donar temps a que tots els fils acabin
            Thread.sleep(repetitions * 3 * 200);  // 3 missatges per cada repetició, 200 ms per missatge
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Programa finalitzat");
    }
}
