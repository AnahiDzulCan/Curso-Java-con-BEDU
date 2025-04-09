import java.util.Scanner;
public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Crear el escáner

        Paciente paciente1 = new Paciente();
        System.out.println("Ingrese el nombre del paciente: ");
        paciente1.paciente = sc.nextLine();

        System.out.println("Ingrese la edad del paciente: ");
        paciente1.edad = sc.nextInt();
        sc.nextLine(); // Limpiar el salto de línea pendiente

        System.out.println("Número de del expendiente: ");
        paciente1.numExpediente = sc.nextLine();

        System.out.println("----------------------------------------------");
        paciente1.mostrarInformacion();

        sc.close(); //Cerrar el escáner
    }
}
