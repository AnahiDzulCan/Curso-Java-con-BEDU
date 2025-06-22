public class CajaRegistradora {

    public static void main(String[] args) {

        MetodoPago[] pagos = {
                new PagoEfectivo(150.0),
                new PagoTarjeta(320.0, 500.0),
                new PagoTransferencia(50.0, false), //Falla a proposito
        };

        for(MetodoPago pago : pagos){

            if(pago.autenticar()){
                System.out.println("\nAutenticación exitosa.");
                pago.procesarPago();
                pago.MostrarResumen();
            }else{
                System.out.println("\nFallo de autenticación. " + pago.getClass().getSimpleName() + " no válido.");
            }

        }

    }

}
