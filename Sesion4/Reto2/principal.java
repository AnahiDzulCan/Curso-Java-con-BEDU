public class principal {
    public static void main(String[] args) {
        declaracionImpuestos declaracion1 = new declaracionImpuestos("XAXX010101000",8700.0);
        cuentaFiscal cuenta1 = new cuentaFiscal("XAXX010101000", 9500.0);

        //ver informacion
        System.out.println("\nDeclaración enviada por FRC: " + declaracion1.rfcContribuyente() + " Por  $ " + declaracion1.montoDeclarado());
        cuenta1.mostrarCuenta();

        //Validar si el rfc coincide y muestra true or false
        boolean rfcValido = cuenta1.validarrfc(declaracion1);
        System.out.println("¿RFC válido para esta cuenta?: " + rfcValido);
    }
}
