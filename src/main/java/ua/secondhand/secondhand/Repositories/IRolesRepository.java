package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Roles;

public interface IRolesRepository extends JpaRepository<Roles, Integer> {
}
