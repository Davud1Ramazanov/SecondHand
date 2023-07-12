package ua.secondhand.secondhand.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.secondhand.secondhand.Models.Commentaries;

public interface ICommentariesRepository extends JpaRepository<Commentaries, Integer> {
}
