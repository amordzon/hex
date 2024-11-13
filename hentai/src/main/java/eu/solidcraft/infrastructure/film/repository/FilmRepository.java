package eu.solidcraft.infrastructure.film.repository;

import eu.solidcraft.film.domain.Film;
import eu.solidcraft.film.domain.FilmBaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface FilmRepository extends Repository<Film, String>, FilmBaseRepository {
    Film save(Film film);
    Film findById(String title);
    Page<Film> findAll(Pageable pageable);
}
