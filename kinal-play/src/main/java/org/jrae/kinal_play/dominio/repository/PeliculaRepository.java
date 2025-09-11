package org.jrae.kinal_play.dominio.repository;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {

    List<PeliculaDto> obtenerTodo();
    PeliculaDto obtenerPeliculaPorCodigo(Long codigo);
    PeliculaDto guardarPelicula(PeliculaDto peliculaDto);
    PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto);

    void eliminarPelicula(Long codigo);

}
