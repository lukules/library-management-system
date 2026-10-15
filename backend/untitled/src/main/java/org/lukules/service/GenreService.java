package org.lukules.service;

import org.lukules.payload.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    GenreDTO createGenre(GenreDTO genre);

    List<GenreDTO> getAllGenres();



}
