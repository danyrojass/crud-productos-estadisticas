package py.com.danyrs.crud_productos.productos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import py.com.danyrs.crud_productos.productos.model.Product;
import py.com.danyrs.crud_productos.productos.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Create a new product", description = "Add a new product to the inventory")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @Operation(summary = "Update a product", description = "Update an existing product")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @Operation(summary = "Delete a product", description = "Remove a product from the inventory")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Get product by ID", description = "Retrieve a product by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Operation(summary = "Search products by name", description = "Search for products based on the provided name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of products retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }
    
}
