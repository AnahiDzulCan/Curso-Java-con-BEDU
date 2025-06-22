import java.io.IOException;
import java.nio.file.*;

public class RegistroSimulacion {

    public static void main(String[] args) {
        Path rutaArchivo = Paths.get("config", "parametros.txt");

        String parametros = """
                Tiempo de ciclo: 55.8 segundos
                Velocidad de línea: 1.2 m/s
                Número de estaciones: 8
                """;

        try {
            guardarParametros(rutaArchivo, parametros);

            if (Files.exists(rutaArchivo)) {
                System.out.println("\nEl archivo fue creado correctamente.\n");
                String contenido = leerParametros(rutaArchivo);
                System.out.println("Contenido del archivo:");
                System.out.println(contenido);
            } else {
                System.out.println("El archivo no fue creado.");
            }

        } catch (IOException e) {
            System.err.println("Error en la operación de archivo: " + e.getMessage());
        }
    }

    public static void guardarParametros(Path ruta, String contenido) throws IOException {
        if (Files.notExists(ruta.getParent())) {
            Files.createDirectories(ruta.getParent());
        }

        Files.writeString(ruta, contenido, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static String leerParametros(Path ruta) throws IOException {
        return Files.readString(ruta);
    }
}

