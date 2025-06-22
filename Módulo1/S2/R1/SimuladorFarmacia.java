public class SimuladorFarmacia {
    String nombreMedicamento;
    double precioUnitario;
    int cantidadPiezas;
    public void generadorTicket(){
        var total = (precioUnitario*cantidadPiezas);

        boolean aplicaDescuento = total > 500;
        //aplica descuento?
        double descuento = aplicaDescuento ? total * 0.15 : 0;
        double totalConDescuento = total - descuento;
        //Ticket
        System.out.println("\n***Farmacias Simuladoras***");
        System.out.println("Medicamento: " + nombreMedicamento);
        System.out.println("Cantidad: " + cantidadPiezas);
        System.out.println("Precio unitario: " + precioUnitario);
        System.out.println("Total sin descuento: " + total);
        System.out.println("¿Aplica descuento? " + aplicaDescuento);
        System.out.println("Descuento: " + descuento);
        System.out.println("Total a pagar: " + totalConDescuento);
    }
}
