package com.bedu.inventario;

import com.bedu.inventario.entity.Categoria;
import com.bedu.inventario.entity.Producto;
import com.bedu.inventario.entity.Marca;
import com.bedu.inventario.repository.CategoriaRepository;
import com.bedu.inventario.repository.MarcaRepository;
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
	public CommandLineRunner demo(ProductoRepository producto, CategoriaRepository categoria, MarcaRepository marca) {
		return (args) -> {
			Categoria tecnologia = new Categoria("Tecnología");
			categoria.save(tecnologia);

			Marca asus = new Marca("ASUS");
			marca.save(asus);

			Marca msi = new Marca("MSI");
			marca.save(msi);

			producto.save(new Producto("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, tecnologia,asus));
			producto.save(new Producto("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, tecnologia,msi));

			System.out.println("Productos por marca:");
			marca.findAll().forEach(Marca -> {
				System.out.println("🏷️ " + Marca.getNombre() + ":");
				producto.findAll().stream()
						.filter(p -> p.getMarca().getId().equals(Marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});
		};
	}
}