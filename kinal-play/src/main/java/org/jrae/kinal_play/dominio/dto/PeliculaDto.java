package org.jrae.kinal_play.dominio.dto;


public record PeliculaDto(
        String name,
        String duration,
        Genre genre,
        String releaseDate,
        Double rating
) {

}
