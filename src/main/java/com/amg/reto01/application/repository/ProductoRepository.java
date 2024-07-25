package com.amg.reto01.application.repository;

import com.amg.reto01.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository {
    List<Product> getAllProduct();
    Product getOneProductoById(Long productoId);
    Product createProducto(Product producto);
    Product editProducto(Long productoId,Product producto);
    void deleteProducto(Long productoId);

}
