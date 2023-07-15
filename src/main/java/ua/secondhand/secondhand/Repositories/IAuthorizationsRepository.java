package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Authorizations;

public interface IAuthorizationsRepository extends JpaRepository<Authorizations, Integer> {
    Authorizations findByName(String name);
}
