package com.bedu.inventario.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;


@Entity
public class Producto {

    @Id // Campo que funcionará como clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)

    private Long id;

    // Campos que serán columnas en la tabla 'producto'
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El campo no debe estar vacío" )
    private String descripcion;
    @Min(1)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Producto(String nombre, String descripción, double precio, Categoria categoria, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripción;
        this.precio =  precio;
        this.categoria = categoria;
        this.marca = marca;
    }

    public Producto(){}

    // Getters para acceder a los atributos (necesarios para el funcionamiento de JPA y buenas prácticas)
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return String.format(
                "Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s']",
                id, nombre, precio, categoria != null ? categoria.getNombre() : "Sin categoría"
        );
    }
}
