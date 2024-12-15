package exercici10;

import java.util.concurrent.Semaphore;

public class TicTacToc extends Thread {
    private String message;
    private Semaphore currentSemaphore;
    private Semaphore nextSemaphore;

    // Constructor per inicialitzar el missatge i els semàfors
    public TicTacToc(String message, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        this.message = message;
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
        try {
            // Esperem fins que sigui el moment de mostrar el missatge
            currentSemaphore.acquire();
            
            // Mostrar el missatge
            System.out.println(message);
            
            // Dormim per poder veure el missatge a la consola abans que el següent fil comenci
            Thread.sleep(200);  // Espera de 200 ms per simular el temps de l'operació
            
            // Alliberem el semàfor per a que el següent fil pugui continuar
            nextSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
