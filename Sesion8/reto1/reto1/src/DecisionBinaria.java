public class DecisionBinaria implements LogicaDecision{

    @Override
    public String decidir(String opcionJugador) {

        if ("1".equals(opcionJugador)) {
            return "1"; // Ir al castillo
        } else if ("2".equals(opcionJugador)) {
            return "2"; // Ir al bosque
        } else {
            return "0"; // Quedarse en pueblo
        }

    }

}
