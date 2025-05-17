import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MonitorCPU {

    public static void main(String[] args) {
        Set<Double> consumos = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Monitoreo de consumo de CPU de servidores");
        System.out.println("Ingrese valores de CPU (%). Escriba 'fin' para terminar.");

        try {
            while (true) {
                System.out.print("➡ Ingrese el consumo: ");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("fin")) {
                    break;
                }

                double valor;
                try {
                    valor = Double.parseDouble(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Error: El valor debe ser numérico.");
                    continue;
                }

                if (valor < 0 || valor > 100) {
                    System.out.println("Valor fuera de rango. Debe estar entre 0 y 100.");
                    continue;
                }

                if (!consumos.add(valor)) {
                    System.out.println("Valor duplicado. No se registra.");
                    continue;
                }

                if (valor > 95) {
                    throw new ConsumoCriticoException("Consumo crítico detectado: " + valor + "%");
                }

                System.out.println("Registro exitoso: " + valor + "%");
            }

            System.out.println("\nResumen del monitoreo:");
            for (double consumo : consumos) {
                System.out.println(consumo + "%");
            }

        } catch (ConsumoCriticoException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Recursos cerrados correctamente.");
        }
    }

}
