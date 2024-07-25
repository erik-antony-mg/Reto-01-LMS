package com.amg.reto01.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    Long productoId;
    @NotBlank
    String nombre;
    String descripcion;
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$" ,message = "solo aceptan numeros y un formato como 12.5")
    @NotBlank(message = "el campo precio no debe estar vacio")
    String precio;
    @Min(value = 0, message = "El stock no puede ser negativo")
    @NotNull(message = " el campo stock no puede ser nulo")
    Integer stock;
    @Column(name = "fecha_creacion")
    LocalDate fechaCreacion;

    @PrePersist
    void guardarFechaCreacion(){
        if (fechaCreacion==null){
            fechaCreacion=LocalDate.now();
        }
    }
}
