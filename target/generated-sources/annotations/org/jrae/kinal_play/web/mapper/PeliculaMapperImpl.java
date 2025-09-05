package org.jrae.kinal_play.web.mapper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.jrae.kinal_play.dominio.Genre;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-05T14:07:21-0600",
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

        PeliculaDto peliculaDto = new PeliculaDto( name, duration, genre, releaseDate, rating );

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
}
