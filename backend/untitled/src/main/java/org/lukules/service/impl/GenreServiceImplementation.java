package org.lukules.service.impl;

import lombok.RequiredArgsConstructor;
import org.lukules.modal.Genre;
import org.lukules.repository.GenreRepository;
import org.lukules.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class GenreServiceImplementation implements GenreService {

    private final GenreRepository genreRepository;


    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);

    }
}
