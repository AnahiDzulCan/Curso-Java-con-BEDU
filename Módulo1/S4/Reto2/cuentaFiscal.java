import java.util.Objects;

public class cuentaFiscal {
    private String rfc; //No se modifica
    private double saldoDisponible;

    //getters
    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    //Constructor y valida que el saldo no sea negativo.
    cuentaFiscal(String rfc, double saldoDisponible) {
        this.rfc = rfc;
        if (saldoDisponible >= 0) {
            this.saldoDisponible = saldoDisponible;
        } else {
            System.out.println("Saldo Insufieciente...");
            this.saldoDisponible = 0;
        }
    }
    //Validar rfc con equals
    public boolean validarrfc(declaracionImpuestos d){
            return Objects.equals(this.rfc, d.rfcContribuyente());
        }

    public void mostrarCuenta(){
            System.out.println("Cuenta fiscal registrada con RFC: " + rfc + "Saldo disponible: $" + saldoDisponible);
        }

}
