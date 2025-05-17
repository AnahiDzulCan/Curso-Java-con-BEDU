public class PagoEfectivo extends MetodoPago implements Autenticable {

    PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        return true;
    }

    @Override
    public void procesarPago(){
        System.out.println("Procesando Pago en efectivo por: $" + monto);
    }
}
