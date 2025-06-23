import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Iniciando accesos a la sala de cirujía...");

        RecursoMedico sala =  new RecursoMedico("Sala de cirugía");
        //crear el pool de 4 hilos a
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //lista de medicos
        String[] profesionales = {
            "Dra. Sanchez","Dr. Gómez","Dr. Martinez"
        };

        //Envio de tareas concurrentes
        for(String nombre: profesionales){
            executor.submit(() -> sala.usar(nombre));
        }

        executor.shutdown();
    }
}
