package exercici3;

public class Programa {

    public static void prova1() {
        Exercici3_Factorial fil1 = new Exercici3_Factorial("Fil 1", 10, Thread.MIN_PRIORITY);
        Exercici3_Factorial fil2 = new Exercici3_Factorial("Fil 2", 10, Thread.MAX_PRIORITY);
        
        fil1.start();
        fil2.start();
        
        try {
            fil1.join();
            fil2.join();
        } catch (InterruptedException e) {
            System.out.println("S'ha produït un error durant l'espera dels fils.");
        }
    }
    
    public static void prova2() {
        Thread[] fils = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            int prioritat = (i < 5) ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            fils[i] = new Exercici3_Factorial("Fil " + (i + 1), 10, prioritat);
            fils[i].start();
        }
        
        for (int i = 0; i < 10; i++) {
            try {
                fils[i].join();
            } catch (InterruptedException e) {
                System.out.println("S'ha produït un error durant l'espera dels fils.");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Prova 1 ---");
        prova1();
        
        System.out.println("--- Prova 2 ---");
        prova2();
    }
}
