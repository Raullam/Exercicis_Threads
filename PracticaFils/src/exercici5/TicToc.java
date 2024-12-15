package exercici5;

public class TicToc extends Thread {
    private String missatge;

    // Constructor que rep el missatge a mostrar ("TIC" o "TAC")
    public TicToc(String missatge) {
        this.missatge = missatge;
    }

    // Mètode run() que es crida quan el fil comença a executar-se
    @Override
    public void run() {
        try {
            System.out.println(missatge);  // Mostrar el missatge (TIC o TAC)
            Thread.sleep(200);  // Espera de 200 ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
