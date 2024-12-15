package exercici3;

class Exercici3_Factorial extends Thread {
    private int numero;

    public Exercici3_Factorial(String nomFil, int numero, int prioritat) {
        super(nomFil);
        this.numero = numero;
        this.setPriority(prioritat);
    }

    @Override
    public void run() {
        long resultat = calcularFibonacci(numero);
        String tipusPrioritat = (this.getPriority() == Thread.MAX_PRIORITY) ? "MAX_PRIORITY" : (this.getPriority() == Thread.MIN_PRIORITY) ? "MIN_PRIORITY" : "NORMAL_PRIORITY";
        System.out.println(getName() + " - " + tipusPrioritat + ": " + resultat);
    }

    private long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}