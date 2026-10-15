package org.lukules.service.impl;

import lombok.RequiredArgsConstructor;
import org.lukules.mapper.GenreMapper;
import org.lukules.modal.Genre;
import org.lukules.payload.dto.GenreDTO;
import org.lukules.repository.GenreRepository;
import org.lukules.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImplementation implements GenreService {

    private final GenreRepository genreRepository;


    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
         // return genreRepository.save(genreDTO);

        Genre genre = Genre.builder()
                .code(genreDTO.getCode())
                .name(genreDTO.getName())
                .description(genreDTO.getDescription())
                .displayOrder(genreDTO.getDisplayOrder())
                .active(true)
                .build();

        if(genreDTO.getParentGenreId() != null) {
            Genre parentGenre = genreRepository.findById(genreDTO.getParentGenreId()).get();
            genre.setParentGenre(parentGenre);
        }

        Genre savedGenre = genreRepository.save(genre);

        GenreDTO dto = GenreMapper.toDTO(savedGenre);



        return dto;

    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(GenreMapper::toDTO)
                .collect(Collectors.toList());


    }
}
