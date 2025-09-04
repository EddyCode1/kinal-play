package org.jrae.kinal_play.repository;

import org.jrae.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {

    List<PeliculaDto> obtenerTodo();
}
