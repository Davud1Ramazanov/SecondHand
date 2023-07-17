package ua.secondhand.secondhand.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authorizations")
public class Authorizations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Roles role;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Password", nullable = false, length = 100)
    private String password;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

}