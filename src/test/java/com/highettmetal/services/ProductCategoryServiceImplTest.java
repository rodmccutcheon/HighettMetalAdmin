package com.highettmetal.services;

import com.highettmetal.domain.ProductCategory;
import com.highettmetal.repositories.ProductCategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ProductCategoryServiceImplTest {

    @TestConfiguration
    static class ProductCategoryServiceImplTestContextConfiguration {

        @MockBean
        private ProductCategoryRepository productCategoryRepository;

        @Bean
        public ProductCategoryService productCategoryService() {
            return new ProductCategoryServiceImpl(productCategoryRepository);
        }
    }

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Before
    public void setup() {
        ProductCategory copper = new ProductCategory("Copper");
        ProductCategory gunmetal = new ProductCategory("Gunmetal");
        List<ProductCategory> allProductCategories = Arrays.asList(copper, gunmetal);

        Mockito.when(productCategoryRepository.findAll()).thenReturn(allProductCategories);
        Mockito.when(productCategoryRepository.findOne(1L)).thenReturn(copper);
        Mockito.when(productCategoryRepository.save(copper)).thenReturn(copper);
    }

    @Test
    public void whenMultipleProductCategoriesExist_thenAllProductCategoriesShouldBeFound() {
        List<ProductCategory> found = productCategoryService.findAllProductCategories();
        assertThat(found.size()).isEqualTo(2);
        assertThat(found.get(0).getName()).isEqualTo("Copper");
        assertThat(found.get(1).getName()).isEqualTo("Gunmetal");
    }

    @Test
    public void whenValidId_thenProductCategoryShouldBeFound() {
        long id = 1L;
        ProductCategory found = productCategoryService.getProductCategoryById(id);
        assertThat(found.getName()).isEqualTo("Copper");
    }

}
