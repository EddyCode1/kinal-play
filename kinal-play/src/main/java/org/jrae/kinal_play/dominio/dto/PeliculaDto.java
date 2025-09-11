package org.jrae.kinal_play.dominio.dto;


import org.jrae.kinal_play.dominio.Genre;

public record PeliculaDto(
        long codigo,
        String name,
        String duration,
        Genre genre,
        String releaseDate,
        Double rating
        //Boolean estado
) {

}
