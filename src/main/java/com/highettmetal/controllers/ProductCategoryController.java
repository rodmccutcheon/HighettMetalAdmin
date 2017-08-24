package com.highettmetal.controllers;

import com.highettmetal.domain.ProductCategory;
import com.highettmetal.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rodmccutcheon on 16/7/17.
 */
@Controller
@RequestMapping("/productCategories")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public String listProductCategories(Model model) {
        model.addAttribute("productCategories", productCategoryService.findAllProductCategories());
        model.addAttribute("productCategory", new ProductCategory());
        return "productCategories/productCategories";
    }

    @PostMapping
    public String saveProductCategory(ProductCategory productCategory) {
        productCategoryService.saveProductCategory(productCategory);
        return "redirect:/productCategories";
    }

    @GetMapping("/{id}")
    public String showProductCategories(@PathVariable Long id, Model model) {
        model.addAttribute("productCategory", productCategoryService.getProductCategoryById(id));
        return "products/prods";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
