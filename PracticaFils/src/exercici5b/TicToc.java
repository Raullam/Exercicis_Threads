package exercici5b;

public class TicToc extends Thread {
    private String missatge;

    // Constructor que rep el missatge a mostrar ("TIC" o "TAC")
    public TicToc(String missatge) {
        this.missatge = missatge;
    }

    // Mètode run() que es crida quan el fil comença a executar-se
    @Override
    public void run() {
        System.out.println(missatge);  // Mostrar el missatge (TIC o TAC)
    }
}
