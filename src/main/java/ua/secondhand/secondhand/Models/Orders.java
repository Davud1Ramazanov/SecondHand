package ua.secondhand.secondhand.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Products product;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "Image", length = 3000)
    private String image;

    @Column(name = "date")
    private Instant date;

}