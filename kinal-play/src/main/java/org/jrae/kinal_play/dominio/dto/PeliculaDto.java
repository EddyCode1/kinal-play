package org.jrae.kinal_play.dominio.dto;


import org.jrae.kinal_play.dominio.Genre;

public record PeliculaDto(
        String name,
        String duration,
        Genre genre,
        String releaseDate,
        Double rating
) {

}
