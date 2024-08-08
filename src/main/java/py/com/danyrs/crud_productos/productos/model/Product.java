package py.com.danyrs.crud_productos.productos.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Schema(description = "Product details")
@Entity
@Data
public class Product {

    @Schema(description = "ID of the product", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Name of the product", example = "Product 1")
    private String name;

    @Schema(description = "Category of the product", example = "Category of Product 1")
    private String category;

    @Schema(description = "Price of the product", example = "100.0")
    private Double price;
}