package ua.secondhand.secondhand.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Categories category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "textile_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Textiles textile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Brands brand;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "Image", nullable = false, length = 3000)
    private String image;

}