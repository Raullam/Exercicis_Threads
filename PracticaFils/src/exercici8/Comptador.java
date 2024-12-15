package exercici8;

import java.util.concurrent.Semaphore;

public class Comptador {
    private int valor = 0; // Valor del comptador
    private final Semaphore semafor = new Semaphore(1); // Semàfor per controlar l'accés al comptador

    // Mètode per obtenir i incrementar el valor del comptador
    public int incrementa() {
        try {
            semafor.acquire(); // Espera per obtenir el semàfor
            int valorActual = valor;
            Thread.sleep(100); // Simula el temps que triga cada fil en modificar el comptador
            valor = valorActual + 1; // Incrementa el valor del comptador
            return valor;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return valor; // Retorna el valor actual en cas d'interrupció
        } finally {
            semafor.release(); // Allibera el semàfor per altres fils
        }
    }
}
