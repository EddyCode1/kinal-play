package org.jrae.kinal_play.web.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.jrae.kinal_play.dominio.Genre;
import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-11T16:17:19-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class PeliculaMapperImpl implements PeliculaMapper {

    @Override
    public PeliculaDto toDto(PeliculaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String name = null;
        String duration = null;
        Genre genre = null;
        String releaseDate = null;
        Double rating = null;
        long codigo = 0L;

        name = entity.getNombre();
        if ( entity.getDuracion() != null ) {
            duration = String.valueOf( entity.getDuracion() );
        }
        genre = GenreMapper.generarGenero( entity.getGenero() );
        if ( entity.getFechaEstreno() != null ) {
            releaseDate = DateTimeFormatter.ISO_LOCAL_DATE.format( entity.getFechaEstreno() );
        }
        if ( entity.getCalificacion() != null ) {
            rating = entity.getCalificacion().doubleValue();
        }
        codigo = entity.getCodigo();

        PeliculaDto peliculaDto = new PeliculaDto( codigo, name, duration, genre, releaseDate, rating );

        return peliculaDto;
    }

    @Override
    public List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PeliculaDto> list = new ArrayList<PeliculaDto>();
        for ( PeliculaEntity peliculaEntity : entities ) {
            list.add( toDto( peliculaEntity ) );
        }

        return list;
    }

    @Override
    public PeliculaEntity toEntity(PeliculaDto peliculaDto) {
        if ( peliculaDto == null ) {
            return null;
        }

        PeliculaEntity peliculaEntity = new PeliculaEntity();

        peliculaEntity.setGenero( GenreMapper.generarGenero( peliculaDto.genre() ) );
        peliculaEntity.setNombre( peliculaDto.name() );
        if ( peliculaDto.duration() != null ) {
            peliculaEntity.setDuracion( Integer.parseInt( peliculaDto.duration() ) );
        }
        if ( peliculaDto.releaseDate() != null ) {
            peliculaEntity.setFechaEstreno( LocalDate.parse( peliculaDto.releaseDate() ) );
        }
        if ( peliculaDto.rating() != null ) {
            peliculaEntity.setCalificacion( BigDecimal.valueOf( peliculaDto.rating() ) );
        }
        peliculaEntity.setCodigo( peliculaDto.codigo() );

        return peliculaEntity;
    }

    @Override
    public void modificarEntityFromDto(ModPeliculaDto modPeliculaDto, PeliculaEntity peliculaEntity) {
        if ( modPeliculaDto == null ) {
            return;
        }

        peliculaEntity.setNombre( modPeliculaDto.name() );
        peliculaEntity.setFechaEstreno( modPeliculaDto.releaseDate() );
        if ( modPeliculaDto.rating() != null ) {
            peliculaEntity.setCalificacion( BigDecimal.valueOf( modPeliculaDto.rating() ) );
        }
        else {
            peliculaEntity.setCalificacion( null );
        }
    }
}
