package py.com.danyrs.crud_productos.productos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import py.com.danyrs.crud_productos.estadisticas.service.StatisticsService;
import py.com.danyrs.crud_productos.productos.model.Product;
import py.com.danyrs.crud_productos.productos.repository.ProductRepository;
import py.com.danyrs.crud_productos.productos.service.ProductService;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final StatisticsService statisticsService;


    @Override
    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        statisticsService.incrementProductCount();
        return savedProduct;
    }

    @Override
    public Product updateProduct(Long id, Product productModified) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productModified.getName());
        product.setCategory(productModified.getCategory());
        product.setPrice(productModified.getPrice());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.findAllByName(name);
    }
    
}
