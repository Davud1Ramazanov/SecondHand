package ua.secondhand.secondhand.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Country", length = 100)
    private String country;

    @Column(name = "FAQ", length = 200)
    private String faq;

    @Column(name = "Image", length = 3000)
    private String image;

}