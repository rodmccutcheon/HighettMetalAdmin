package com.highettmetal.repositories;

import com.highettmetal.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rodmccutcheon on 16/7/17.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
