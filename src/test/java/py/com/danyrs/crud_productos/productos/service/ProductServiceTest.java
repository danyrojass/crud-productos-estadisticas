package py.com.danyrs.crud_productos.productos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import py.com.danyrs.crud_productos.estadisticas.service.StatisticsService;
import py.com.danyrs.crud_productos.productos.model.Product;
import py.com.danyrs.crud_productos.productos.repository.ProductRepository;
import py.com.danyrs.crud_productos.productos.service.impl.ProductServiceImpl;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StatisticsService statisticsService;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setCategory("Category 1");
        product.setPrice(10.0);
    }

    @Test
    void saveProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product savedProduct = productService.saveProduct(product);
        assertNotNull(savedProduct);
        assertEquals(product.getName(), savedProduct.getName());
        verify(statisticsService, times(1)).incrementProductCount();
    }

    @Test
    void updateProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product updatedProduct = productService.updateProduct(product.getId(), product);
        assertNotNull(updatedProduct);
        assertEquals(product.getName(), updatedProduct.getName());
    }

    @Test
    void deleteProduct() {
        doNothing().when(productRepository).deleteById(product.getId());
        productService.deleteProduct(product.getId());
        verify(productRepository, times(1)).deleteById(product.getId());
    }

    @Test
    void getAllProducts() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(products);
        List<Product> fetchedProducts = productService.getAllProducts();
        assertNotNull(fetchedProducts);
        assertEquals(1, fetchedProducts.size());
    }

    @Test
    void getProductById() {
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Product fetchedProduct = productService.getProductById(product.getId()).get();
        assertNotNull(fetchedProduct);
        assertEquals(product.getName(), fetchedProduct.getName());
    }

    @Test
    void searchProductsByName() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAllByName("Test")).thenReturn(products);
        List<Product> fetchedProducts = productService.searchProductsByName("Test");
        assertNotNull(fetchedProducts);
        assertEquals(1, fetchedProducts.size());
    }
}