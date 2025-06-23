import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal {
    public static void main(String[] args) {

        System.out.println("Simulación de misión espacial iniciada...");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //Enviar tareas al pool
        Future<String> nav = executor.submit(new SistemaNavegacion());
        Future<String> sopVital = executor.submit(new SistemaSoportevital());
        Future<String> sisTermico = executor.submit(new SistemaControlTermico());
        Future<String> sisComunicacion = executor.submit(new SistemaComunicaciones());

         try {
            // Recuperar e imprimir resultados
            System.out.println(nav.get());
            System.out.println(sopVital.get());
            System.out.println(sisTermico.get());
            System.out.println(sisComunicacion.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error durante la ejecución: " + e.getMessage());
        } finally {
            // Cerrar el executor
            executor.shutdown();
        }
    
}
}
