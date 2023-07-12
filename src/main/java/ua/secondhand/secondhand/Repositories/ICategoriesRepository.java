package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Categories;

public interface ICategoriesRepository extends JpaRepository<Categories, Integer> {
}
