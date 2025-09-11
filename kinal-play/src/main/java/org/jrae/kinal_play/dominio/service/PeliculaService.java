package org.jrae.kinal_play.dominio.service;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository){
        this.peliculaRepository = peliculaRepository;

    }

    public List<PeliculaDto> obtenerTodo(){
        return this.peliculaRepository.obtenerTodo();
    }

    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo){
        return this.peliculaRepository.obtenerPeliculaPorCodigo(codigo);
    }

    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto){
        return this.peliculaRepository.guardarPelicula(peliculaDto);
    }

    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto){
        return this.peliculaRepository.modificarPelicula(codigo, modPeliculaDto);
    }
}
