package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Products;

import java.util.List;

public interface IProductsRepository extends JpaRepository<Products, Integer> {
    Products findByName(String name);
    Products findByTextileIdAndName(Integer id, String name);
    Products findByBrandIdAndName(Integer id, String name);
    List<Products> findByTextileId(Integer id);
    List<Products> findByBrandId(Integer id);
}
