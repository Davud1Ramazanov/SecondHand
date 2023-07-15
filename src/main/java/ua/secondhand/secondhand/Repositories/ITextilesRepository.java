package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Textiles;

public interface ITextilesRepository extends JpaRepository<Textiles, Integer> {
    Textiles findByName(String name);
}
