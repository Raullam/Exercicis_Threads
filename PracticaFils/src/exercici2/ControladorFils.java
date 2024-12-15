package exercici2;

public class ControladorFils {
    public static void main(String[] args) {
        try {
            Thread filSuma = new Fil(1, 1); // Fil que suma 10
            Thread filResta = new Fil(2, -1); // Fil que resta 10

            filSuma.start(); // Inicia el fil de suma
            filResta.start(); // Inicia el fil de resta

            filSuma.join(); // Espera que el fil de suma acabi
            filResta.join(); // Espera que el fil de resta acabi

            // Mostra el valor final de 'compte'
            System.out.println("Fil principal: " + Fil.compte[0]);
        } catch (InterruptedException e) {
            System.out.println("S'ha produït un error durant l'espera dels fils.");
        }
    }
}

