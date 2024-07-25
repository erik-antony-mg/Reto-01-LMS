package com.amg.reto01.infrastructure.persistence.repository;

import com.amg.reto01.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoPersistence extends JpaRepository<Product,Long> {
}
