package com.highettmetal.services;

import com.highettmetal.domain.Product;

import java.util.List;

/**
 * Created by rodmccutcheon on 17/7/17.
 */
public interface ProductService {
    List<Product> listAllProducts();

    List<Product> listProductsForProductCategory(Long id);

    Product getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}
