package ua.secondhand.secondhand.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Authorizations user;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date date = new Date();

}