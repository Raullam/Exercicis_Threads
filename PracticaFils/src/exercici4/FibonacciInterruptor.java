package exercici4;

import java.util.Scanner;

public class FibonacciInterruptor {
    
    private final FibonacciCalculator fibonacciCalculator;

    // Constructor que rep una instància de FibonacciCalculator
    public FibonacciInterruptor(FibonacciCalculator fibonacciCalculator) {
        this.fibonacciCalculator = fibonacciCalculator;
    }

    // Funció per gestionar la interrupció del fil
    public void gestionarInterrupcio() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introdueix una comanda (escriu 'exit' per aturar): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                fibonacciCalculator.interrompre();
                System.out.println("El fil principal ha aturat el fil de càlcul.");
                break;
            }
        }
        scanner.close();
    }
}
