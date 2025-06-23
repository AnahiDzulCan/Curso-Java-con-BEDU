public class Principal {

    public static void main(String[] args) {
        MiPrimerHilo primerHilo = new MiPrimerHilo();

        primerHilo.start();

        MiSegundoHilo segundoHiloRunnable = new MiSegundoHilo();
        Thread segundoHilo = new Thread(segundoHiloRunnable);
        segundoHilo.start();
    }
}