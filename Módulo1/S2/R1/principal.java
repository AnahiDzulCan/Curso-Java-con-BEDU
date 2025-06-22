import java.util.Scanner;
public class principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        SimuladorFarmacia simular = new SimuladorFarmacia();

        //pedir datos
        System.out.println("Bienvenido al sistema, por favor agregue los datos siguientes y continue la compra...");
        System.out.println("Nombre del medicamento: ");
        simular.nombreMedicamento = teclado.nextLine();

        System.out.println("Precio por unidad: ");
        simular.precioUnitario = teclado.nextDouble();

        System.out.println("Cantidad de piezas: ");
        simular.cantidadPiezas = teclado.nextInt();

        teclado.close();
        simular.generadorTicket();
    }
}

