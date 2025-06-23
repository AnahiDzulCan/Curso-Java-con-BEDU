package org.bedu.MeridianPrime;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeridianPrimeApplication {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();

        Flux<String> sensorTrafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(nivel -> nivel > 70)
                .map(nivel -> "Alerta: Congestión del " + nivel + "% en Avenida Solar")
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());

		Flux<String> sensorAire = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " µg/m3)")
                .subscribeOn(Schedulers.parallel());

		Flux<String> Accidentes = Flux.interval(Duration.ofMillis(800))
		        .map(i -> {
					String[] prioridades = {"Baja", "Media", "Alta"};
					return prioridades[random.nextInt(prioridades.length)];
				})
				.filter(p -> p.equals("Alta"))
				.map(p -> "Emergencia vial: Accidente con prioridad "+ p)
				.subscribeOn(Schedulers.parallel());
			
		Flux<String> Trenes = Flux.interval(Duration.ofMillis(700))
		       .map(i -> random.nextInt(11))
			   .filter(min -> min > 5)
			   .map(min -> "Tren maglev con retraso crítico: "+ min + "minutos")
			   .delayElements(Duration.ofMillis(300))
			   .onBackpressureBuffer()
			   .subscribeOn(Schedulers.parallel());

		Flux<String> Semaforos = Flux.interval(Duration.ofMillis(400))
		        .map(i -> {
					String[] estados ={"Verde", "Amarillo","Rojo"};
					return estados[random.nextInt(estados.length)];
				})
				.buffer(5,1)
				.filter(lista -> lista.stream().filter(color -> color.equals("Rojo")).count() >= 3)
				.map(lista -> "Semáforo en rojo detectado 3 veces seguidas en cruce Norte")
				.subscribeOn(Schedulers.parallel());

		Flux<String> eventosCombinados =  Flux.merge(sensorTrafico, sensorAire, Accidentes,Trenes,Semaforos);

        eventosCombinados
                .window(Duration.ofSeconds(1))
                .flatMap(ventana -> ventana.collectList()
                        .filter(lista -> lista.size() >= 3)
                        .doOnNext(lista -> {
                            lista.forEach(System.out::println);
                            System.out.println("Alerta global: Múltiples eventos críticos detectados en Meridian Prime");
                            System.out.println("─────────────────────────────────────────────");
                        }))
                .subscribe();
        Thread.sleep(15000);

	}

}
