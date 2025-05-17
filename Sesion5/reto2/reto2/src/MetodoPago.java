public abstract class MetodoPago implements Autenticable {
    double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    public abstract void procesarPago();

    public void MostrarResumen(){
        System.out.println("Tipo: " + this.getClass().getSimpleName() + " - Monto: $" + monto);
    }

}
