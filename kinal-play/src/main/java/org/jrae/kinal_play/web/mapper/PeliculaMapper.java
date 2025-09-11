package org.jrae.kinal_play.web.mapper;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
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

    //para convertir DTO --> Entity --> toEntity
    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "generarGenero")
    PeliculaEntity toEntity (PeliculaDto peliculaDto);

    // Auto actulizar el metodoPeliculaDto a PeliculaEntity

    @Mapping( source = "name", target = "nombre")
    @Mapping( source = "releaseDate", target = "fechaEstreno")
    @Mapping( source = "rating", target = "calificacion")
    void modificarEntityFromDto(ModPeliculaDto modPeliculaDto, @MappingTarget PeliculaEntity peliculaEntity);

}
