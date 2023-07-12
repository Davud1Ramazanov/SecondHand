package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Orders;

public interface IOrdersRepository extends JpaRepository<Orders, Integer> {
}
