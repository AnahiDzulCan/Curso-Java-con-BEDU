package org.bedu.MonitoreoUCI;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

@SpringBootApplication
public class MonitoreoUciApplication {

	static Random random = new Random();

	public static void main(String[] args) throws InterruptedException {
		Flux<String> paciente1 = generarPaciente("Paciente 1");
		Flux<String> paciente2 = generarPaciente("Paciente 2");
		Flux<String> paciente3 = generarPaciente("Paciente 3");

		Flux.merge(paciente1, paciente2, paciente3)
				.subscribe(System.out::print);

		Thread.sleep(20000);
	}

	public static Flux<String> generarPaciente(String nombre) {
		return Flux.interval(Duration.ofMillis(300))
				.map(i -> {
					int fc = 40 + random.nextInt(101);
					int sistolica = 80 + random.nextInt(81);
					int diastolica = 50 + random.nextInt(41);
					int spo2 = 85 + random.nextInt(16);

					StringBuilder alerta = new StringBuilder();

					if (fc < 50 || fc > 120) {
						alerta.append("⚠️ ").append(nombre).append(" - FC crítica: ").append(fc).append(" bpm\n");
					}

					if (sistolica < 90 || sistolica > 140 || diastolica < 60 || diastolica > 90) {
						alerta.append("⚠️ ").append(nombre).append(" - PA crítica: ")
								.append(sistolica).append("/").append(diastolica).append(" mmHg\n");
					}

					if (spo2 < 90) {
						alerta.append("⚠️ ").append(nombre).append(" - SpO2 baja: ").append(spo2).append("%\n");
					}

					return alerta.toString();
				})
				.filter(msg -> !msg.isEmpty())
				.delayElements(Duration.ofSeconds(1));
	}

}
