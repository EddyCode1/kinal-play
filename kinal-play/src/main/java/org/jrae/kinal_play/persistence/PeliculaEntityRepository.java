package org.jrae.kinal_play.persistence;

import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.exception.PeliculaNoExisteException;
import org.jrae.kinal_play.dominio.exception.PeliculaYaExisteException;
import org.jrae.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.jrae.kinal_play.dominio.repository.PeliculaRepository;
import org.jrae.kinal_play.persistence.entity.PeliculaEntity;
import org.jrae.kinal_play.web.mapper.PeliculaMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
// @Data
public class PeliculaEntityRepository implements PeliculaRepository {

    // Inyeccion de dependencias implicito
    private final CrudPeliculaEntity crudPelicula;
    private final PeliculaMapper peliculaMapper;

    public PeliculaEntityRepository(CrudPeliculaEntity crudPelicula, PeliculaMapper peliculaMapper) {
        this.crudPelicula = crudPelicula;
        this.peliculaMapper = peliculaMapper;
    }

    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPelicula.findAll());
    }

    @Override
    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo) {
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));

    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        //buscarPorTitulo

        if (this.crudPelicula.findFirstByNombre(peliculaDto.name()) !=null){
            throw  new PeliculaYaExisteException(peliculaDto.name());
        }
        PeliculaEntity peliculaEntity = this.crudPelicula.findFirstByNombre(peliculaDto.name());
        //Instanciar clase de entidad
        PeliculaEntity pelicula = new PeliculaEntity();
        // Convertir de Dto a Entity
        pelicula = this.peliculaMapper.toEntity(peliculaDto);
        pelicula.setEstado("D");

        //Guardar en la base de datos JPA
        this.crudPelicula.save(pelicula);
        //Retornar el valor guardado como DTO
        return this.peliculaMapper.toDto(pelicula);
    }

    @Override
    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
        // public void modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
        //Obtenemos PeliculaEntity con el codigo
        PeliculaEntity pelicula = this.crudPelicula.findById(codigo).orElse(null);
        //Modificar atributos de ella con datos del mod
//        pelicula.setNombre(modPeliculaDto.name());
//        pelicula.setFechaEstreno(modPeliculaDto.releaseDate());
//        pelicula.setCalificacion(BigDecimal.valueOf(modPeliculaDto.rating()));
//        //Guardamos en la db
//        //Retornamos el PeliculaDTO convertido de la entidad
//        return null;
        this.peliculaMapper.modificarEntityFromDto(modPeliculaDto, pelicula);
        return this.peliculaMapper.toDto(this.crudPelicula.save(pelicula));


    }
    @Override
    public void eliminarPelicula(Long codigo){
        PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);

        if (peliculaEntity == null ){
            //excepcion
            throw new PeliculaNoExisteException(codigo);
        } else {
            this.crudPelicula.findById(codigo);
        }

    }
}
