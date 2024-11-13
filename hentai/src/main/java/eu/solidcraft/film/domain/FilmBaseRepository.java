package eu.solidcraft.film.domain;

import eu.solidcraft.film.dto.FilmNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmBaseRepository {
    Film save(Film film);
    Film findById(String title);
    Page<Film> findAll(Pageable pageable);

    default Film findOneOrThrow(String title) {
        Film film = findById(title);
        if(film == null) {
            throw new FilmNotFoundException(title);
        }
        return film;
    }
}
