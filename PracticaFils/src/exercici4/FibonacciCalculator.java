package exercici4;

public class FibonacciCalculator {
    private boolean interromput = false;

    // Funció per calcular els N primers números de Fibonacci
    public void calcularFibonacci(int n) {
        long fib1 = 1, fib2 = 1;
        int count = 0;

        while (count < n) {
            if (interromput) {
                System.out.println("El fil de càlcul ha estat interromput.");
                return;
            }

            System.out.println("Fibonacci " + (count + 1) + ": " + fib1);
            long nextFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = nextFib;

            count++;
            try {
                Thread.sleep(50);  // Espera de 50 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("El càlcul de Fibonacci ha finalitzat.");
    }

    // Funció per actualitzar l'estat de la interrupció
    public void interrompre() {
        interromput = true;
    }
}
