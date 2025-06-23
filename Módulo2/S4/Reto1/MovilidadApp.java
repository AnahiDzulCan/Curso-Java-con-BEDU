import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    public static void main(String[] args) {

System.out.println("\n Iniciando simulación de viaje... \n");
    CompletableFuture<String> rutaFuture =  calcularRuta();
    CompletableFuture<Double> tarifaFuture = estimarTarifa();

    CompletableFuture<Void> viajeCompleto = rutaFuture.thenCombine(tarifaFuture,
     (ruta, tarifa) -> {
        return " Ruta Calculada: " + ruta + " -- Tarifa estimada: $" + tarifa + "\n";
     })
     .thenAccept(System.out::println)
     .exceptionally(exepcion -> {
        System.out.println("Error al procesar viaje: " + exepcion.getMessage());
        return null;
     });

     viajeCompleto.join();
    }
     public static CompletableFuture<String> calcularRuta(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(" Calcular ruta...");
            dormir(3);
            return "Centro -> Norte";
        });
     }

     public static CompletableFuture<Double> estimarTarifa(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(" Estimando tarifa...");
            dormir(2);
            return 75.50;
        });
     }

     public static void dormir (int segundos){
        try{
            TimeUnit.SECONDS.sleep(segundos);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
     }     
    }

    