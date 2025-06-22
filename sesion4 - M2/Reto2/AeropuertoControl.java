import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println(" Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

        CompletableFuture<Void> controlAterrizaje = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenAccept(v -> {
                    try {
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoFuture.get();
                        boolean personal = personalFuture.get();
                        //No deberia usar muchos if :c
                        if (pista && clima && trafico && personal) {
                            System.out.println("\nAterrizaje autorizado: todas las condiciones óptimas\n");
                        } else {
                            System.out.println("\nAterrizaje denegado: condiciones no óptimas\n");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("\nError en la evaluación de condiciones: " + e.getMessage());
                    }
                })
                .exceptionally(exepcion -> {
                    System.out.println("\nError en el proceso de aterrizaje: " + exepcion.getMessage());
                    return null;
                });

        controlAterrizaje.join();
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando pista...");
            dormir(2);
            boolean disponible = random.nextInt(100) < 80;
            System.out.println("\nPista disponible: " + disponible);
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando clima...");
            dormir(3);
            boolean bueno = random.nextInt(100) < 85;
            System.out.println("\nClima favorable: " + bueno);
            return bueno;
        });
    }

  
    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando el tráfico aéreo...");
            dormir(1);
            boolean libre = random.nextInt(100) < 90;
            System.out.println("\nTráfico aéreo despejado: " + libre);
            return libre;
        });
    }


    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando el personal en tierra...");
            dormir(2);
            boolean disponible = random.nextInt(100) < 95; 
            System.out.println("\nPersonal disponible: " + disponible);
            return disponible;
        });
    }

    public static void dormir(int seg) {
        try {
            TimeUnit.SECONDS.sleep(seg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    }