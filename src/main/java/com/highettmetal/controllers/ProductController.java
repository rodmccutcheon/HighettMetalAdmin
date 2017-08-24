package com.highettmetal.controllers;

import com.highettmetal.services.ProductCategoryService;
import com.highettmetal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rodmccutcheon on 17/7/17.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductCategoryService productCategoryService;
    private ProductService productService;

    @Autowired
    public ProductController(ProductCategoryService productCategoryService, ProductService productService) {
        this.productCategoryService = productCategoryService;
        this.productService = productService;
    }

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("productCategories", productCategoryService.findAllProductCategories());
        return "products/products";
    }


}
