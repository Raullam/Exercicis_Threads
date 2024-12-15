package exercici7;

public class Main {
    public static void main(String[] args) {
        // Demanar a l'usuari el valor inicial de la compte enrere
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Introdueix el temps de compte enrere en segons: ");
        int tempsInicial = scanner.nextInt();
        scanner.close();
        
        // Crear els fils
        CompteEnrere compteEnrere = new CompteEnrere(tempsInicial);
        Avís avís = new Avís(compteEnrere);
        
        // Iniciar els fils
        compteEnrere.start();
        avís.start();
        
        // Esperar que tots els fils acabin
        try {
            compteEnrere.join();
            avís.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Mostrar el missatge final quan els fils hagin acabat
        System.out.println("Programa finalitzat");
    }
}
