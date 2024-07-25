package com.amg.reto01.application.service;

import com.amg.reto01.application.repository.ProductoRepository;
import com.amg.reto01.domain.entity.Product;
import com.amg.reto01.domain.exceptions.ProductoNotFound;
import com.amg.reto01.infrastructure.persistence.repository.ProductoPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements ProductoRepository {

    private final ProductoPersistence productoPersistence;

    @Override
    public List<Product> getAllProduct() {
        return productoPersistence.findAll();
    }

    @Override
    public Product getOneProductoById(Long productoId) {
        return productoPersistence.findById(productoId)
                .orElseThrow(()-> new ProductoNotFound("producto con el id "+productoId+" no encontrado"));
    }

    @Override
    public Product createProducto(Product producto) {
        return productoPersistence.save(producto);
    }

    @Override
    public Product editProducto(Long productoId, Product producto) {
        Product productoEcontrado=productoPersistence.findById(productoId)
                .orElseThrow(()-> new ProductoNotFound("producto con el id "+productoId+" no encontrado"));
        productoEcontrado.setProductoId(productoId);
        if (producto.getStock()!=null){
            productoEcontrado.setStock(producto.getStock());
        }
        if (producto.getPrecio()!=null){
            productoEcontrado.setPrecio(producto.getPrecio());
        }
        if (producto.getDescripcion()!=null){
            productoEcontrado.setDescripcion(producto.getDescripcion());
        }
        if (producto.getNombre()!=null){
            productoEcontrado.setNombre(producto.getNombre());
        }
        return productoPersistence.save(productoEcontrado);
    }

    @Override
    public void deleteProducto(Long productoId) {
        Product productoEcontrado=productoPersistence.findById(productoId)
                .orElseThrow(()-> new ProductoNotFound("producto con el id "+productoId+" no encontrado"));
        productoPersistence.deleteById(productoEcontrado.getProductoId());
    }
}
