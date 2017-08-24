package com.highettmetal.repositories;

import com.highettmetal.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rodmccutcheon on 17/7/17.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductCategoryId(Long id);
}
