package com.highettmetal.restcontrollers;

import com.highettmetal.domain.ProductCategory;
import com.highettmetal.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class PriceListRestController {

    private ProductCategoryService productCategoryService;

    @Autowired
    public PriceListRestController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/api/getScrapPriceList")
    public HashMap<String, List<ProductCategory>> getScrapPriceList() {
        HashMap<String, List<ProductCategory>> returnMap = new HashMap<>();
        returnMap.put("categories", productCategoryService.findAllProductCategories());
        return returnMap;
    }
}
