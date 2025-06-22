import java.io.*;
import java.nio.file.*;

public class AnalizadorDeLogs {

    public static void main(String[] args) {
        Path rutaLog = Paths.get("errores.log");
        int totalLineas = 0;
        int errores = 0;
        int advertencias = 0;

        // Try-with-resources para asegurar cierre del archivo
        try (BufferedReader lector = Files.newBufferedReader(rutaLog)) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    errores++;
                }
                if (linea.contains("WARNING")) {
                    advertencias++;
                }
            }

            // Mostrar resumen
            System.out.println("\nResumen del análisis:");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + errores);
            System.out.println("Cantidad de advertencias: " + advertencias);

            double porcentaje = ((double)(errores + advertencias) / totalLineas) * 100;
            System.out.printf("Porcentaje de líneas con errores o advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            // Guardar el mensaje de error en registro_fallos.txt
            Path rutaRegistro = Paths.get("registro_fallos.txt");
            try {
                String mensaje = "Error al leer el archivo: " + e.getMessage();
                Files.writeString(rutaRegistro, mensaje, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.err.println(mensaje);
            } catch (IOException ex) {
                System.err.println("No se pudo registrar el fallo: " + ex.getMessage());
            }
        }
    }
}
