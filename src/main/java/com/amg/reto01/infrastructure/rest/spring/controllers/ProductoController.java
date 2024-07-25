package com.amg.reto01.infrastructure.rest.spring.controllers;

import com.amg.reto01.application.repository.ProductoRepository;
import com.amg.reto01.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository productoRepository;

    @GetMapping
    ResponseEntity<List<Product>>getAllProductos(){
        if (productoRepository.getAllProduct().isEmpty()){
            return new ResponseEntity<>(productoRepository.getAllProduct(), HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(productoRepository.getAllProduct());
    }

    @PostMapping("/crear")
    ResponseEntity<Product> createProducto( @RequestBody @Validated Product producto){
        return new ResponseEntity<>(productoRepository.createProducto(producto),HttpStatus.CREATED);
    }

    @PutMapping("/editar/{productoId}")
    ResponseEntity<Product> editProducto(@PathVariable Long productoId,@RequestBody Product producto){
        return ResponseEntity.ok(productoRepository.editProducto(productoId,producto));
    }
    @DeleteMapping("/delete/{productoId}")
    ResponseEntity<Map<String,String>> deleteMapping(@PathVariable Long productoId){
        Map<String,String> resp= new HashMap<>();
        resp.put("mensaje","producto con el id :"+productoId+" fue eliminado");
        productoRepository.deleteProducto(productoId);
        return ResponseEntity.ok(resp);
    }
}
