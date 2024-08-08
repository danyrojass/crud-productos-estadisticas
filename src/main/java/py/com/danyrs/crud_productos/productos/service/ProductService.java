package py.com.danyrs.crud_productos.productos.service;

import java.util.List;
import java.util.Optional;

import py.com.danyrs.crud_productos.productos.model.Product;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product productModified);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    List<Product> searchProductsByName(String name);
}
