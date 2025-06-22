import java.util.Scanner;

public class MainNarrativa {

    private final TransicionHistoria transicion;
    private final GestorDialogo dialogo;
    private final LogicaDecision decision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo dialogo, LogicaDecision decision) {
        this.transicion = transicion;
        this.dialogo = dialogo;
        this.decision = decision;
    }

    public void ejecutarEscena() {
        dialogo.mostrarDialogo("Te encuentras en la plaza del pueblo. ¿Qué haces?\n" +
                "1) Ir al castillo\n" +
                "2) Explorar el bosque\n" +
                "Otro) Quedarte en el pueblo");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Elige una opción: ");
        String opcion = scanner.nextLine();

        String resultadoDecision = decision.decidir(opcion);
        transicion.transicionar(resultadoDecision);
        dialogo.mostrarDialogo("Fin de la escena.");
        scanner.close();
    }

    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();

        MainNarrativa narrativa = new MainNarrativa(transicion, dialogo, decision);
        narrativa.ejecutarEscena();
    }
}
