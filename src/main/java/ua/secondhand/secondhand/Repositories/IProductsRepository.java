package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Products;

public interface IProductsRepository extends JpaRepository<Products, Integer> {
}
