package eu.solidcraft.application.film.facade;

import eu.solidcraft.film.domain.Film;
import eu.solidcraft.film.domain.FilmBaseRepository;
import eu.solidcraft.film.domain.FilmCreator;
import eu.solidcraft.film.dto.FilmDto;
import eu.solidcraft.infrastructure.metrics.logging.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

@Transactional
@Log
public class FilmFacade {
    private FilmBaseRepository filmBaseRepository;
    private FilmCreator filmCreator;

    public FilmFacade(FilmBaseRepository filmBaseRepository, FilmCreator filmCreator) {
        this.filmBaseRepository = filmBaseRepository;
        this.filmCreator = filmCreator;
    }

    public FilmDto add(FilmDto filmDto) {
        requireNonNull(filmDto);
        Film film = filmCreator.from(filmDto);
        film =  filmBaseRepository.save(film);
        return film.dto();
    }

    public FilmDto show(String filmDto) {
        requireNonNull(filmDto);
        Film film = filmBaseRepository.findOneOrThrow(filmDto);
        return film.dto();
    }

    public Page<FilmDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return filmBaseRepository
                .findAll(pageable)
                .map(film -> film.dto());
    }
}
