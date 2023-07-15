package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Brands;

public interface IBrandsRepository extends JpaRepository<Brands, Integer> {
    Brands findByName(String name);
}
