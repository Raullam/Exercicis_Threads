package exercici4;

public class Main {
    public static void main(String[] args) {
        // Demanar a l'usuari quants nombres de Fibonacci vol calcular
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Quants nombres de la successió de Fibonacci vols calcular? ");
        int n = scanner.nextInt();

        // Crear la instància de FibonacciCalculator
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();

        // Crear la instància de FibonacciInterruptor, passant la referència de FibonacciCalculator
        FibonacciInterruptor fibonacciInterruptor = new FibonacciInterruptor(fibonacciCalculator);

        // Crear i iniciar el fil de càlcul de Fibonacci
        Thread filCalcul = new Thread(() -> fibonacciCalculator.calcularFibonacci(n));

        // Crear i iniciar el fil per gestionar la interrupció
        Thread filInterrupcio = new Thread(fibonacciInterruptor::gestionarInterrupcio);

        // Iniciar els fils
        filCalcul.start();
        filInterrupcio.start();

        try {
            // Esperar que els fils acabin
            filCalcul.join();
            filInterrupcio.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
