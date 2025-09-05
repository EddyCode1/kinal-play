package org.jrae.kinal_play.web.mapper;

import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface PeliculaMapper {

    // Firmas de metodos: toDto -> Convertir a DTO
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "generarGenero")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    public PeliculaDto toDto(PeliculaEntity entity);

    public List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities);

}
