package ua.secondhand.secondhand.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "textiles")
public class Textiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "textile_id", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Length", nullable = false)
    private Integer length;

    @Column(name = "Height", nullable = false)
    private Integer height;

    @Column(name = "Image", length = 3000)
    private String image;

}