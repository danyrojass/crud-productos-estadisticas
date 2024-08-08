package py.com.danyrs.crud_productos.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.danyrs.crud_productos.productos.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
}