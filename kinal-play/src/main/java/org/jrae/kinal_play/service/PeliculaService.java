package org.jrae.kinal_play.service;

import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.repository.PeliculaRepository;

import java.util.List;

public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository){
        this.peliculaRepository = peliculaRepository;

    }

    public List<PeliculaDto> obtenerTodo(){
        return this.peliculaRepository.obtenerTodo();
    }

}
