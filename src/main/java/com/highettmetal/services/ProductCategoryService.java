package com.highettmetal.services;

import com.highettmetal.domain.ProductCategory;

import java.util.List;

/**
 * Created by rodmccutcheon on 16/7/17.
 */
public interface ProductCategoryService {
    List<ProductCategory> findAllProductCategories();

    ProductCategory getProductCategoryById(Long id);

    ProductCategory saveProductCategory(ProductCategory productCategory);

    void deleteProductCategory(Long id);
}
