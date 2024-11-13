package eu.solidcraft.infrastructure.film.configuration;

import eu.solidcraft.film.domain.FilmCreator;
import eu.solidcraft.application.film.facade.FilmFacade;
import eu.solidcraft.infrastructure.film.repository.FilmRepository;
import eu.solidcraft.infrastructure.film.repository.InMemoryFilmRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilmConfiguration {

    FilmFacade filmFacade() {
        FilmCreator filmCreator = new FilmCreator();
        return new FilmFacade(new InMemoryFilmRepository(), filmCreator);
    }

    @Bean
    FilmFacade filmFacade(FilmRepository filmRepository) {
        FilmCreator filmCreator = new FilmCreator();
        return new FilmFacade(filmRepository, filmCreator);
    }
}
