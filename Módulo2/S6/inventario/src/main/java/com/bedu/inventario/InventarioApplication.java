package com.bedu.inventario;

import com.bedu.inventario.entity.Producto;
import com.bedu.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository repository) {
		return (args) -> {
			// Guardar algunos productos
			repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
			repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
			repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));

			//Agrega 5 productos nuevos
			repository.save(new Producto("Monitor","Grande 32 pulgadas",4500));
			repository.save(new Producto("Trajeta de video","Rtx 2 generación",5100));
			repository.save(new Producto("mousepad","One piece",600));
			repository.save(new Producto("Audifonos RGB","Aislante de ruido", 310));
			repository.save(new Producto("Silla Gamer", "Ergonomica", 2300));

			// Mostrar todos los productos
			System.out.println("\n Productos disponibles:");
			repository.findAll().forEach(System.out::println);


			System.out.println("\n🔍 Productos que contienen 'Lap':");
			repository.findByNombreContaining("Lap").forEach(System.out::println);

			System.out.println("\n💵 Productos con precio mayor a 500");
			repository.findByPrecioBetween(500,100000).forEach(System.out::println);

			System.out.println("\n💰Productos entre  los precios 400 y 1000");
			repository.findByPrecioBetween(400,1000).forEach(System.out::println);

			System.out.println("\n🔍Productos con m o M");
			repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);


		};
	}
}