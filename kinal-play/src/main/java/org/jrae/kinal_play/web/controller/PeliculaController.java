package org.jrae.kinal_play.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jrae.kinal_play.dominio.dto.ModPeliculaDto;
import org.jrae.kinal_play.dominio.dto.PeliculaDto;
import org.jrae.kinal_play.dominio.service.PeliculaService;
import org.mapstruct.Mapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/peliculas")
@Tag(name = "Peliculas", description = "Opciones (CRUD) sobre las peliculas de kinal-play")
public class PeliculaController {   
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerTodo(){
        // 200: OK, todo funciono correctamente
        // 404: No lo encuentra, no existe, mal nombre
        // 500: Interno del servidor, error de lógica
        // 405: Método de solicitud incorrecto
        return ResponseEntity.ok(this.peliculaService.obtenerTodo());
    }

    // 4
    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener una pelicula a travez de su identificador",
            description = "Retorna la pelicula que conincida con el identificador envido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula fue encontrada conexito"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada", content = @Content)
            }
    )
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo
    (@Parameter(description = "Identificador de la pelicula a registrar", example = "5")
     @PathVariable Long codigo){
        return  ResponseEntity.ok(this.peliculaService.obtenerPeliculaPorCodigo(codigo));
    }

    // Guardar película
    @PostMapping
    public ResponseEntity<PeliculaDto>guardarPelicula
    (@RequestBody PeliculaDto peliculaDto){
        // return this.peliculaService.guardarPelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.peliculaService.guardarPelicula(peliculaDto));
    }

    // Modificar película
    @PutMapping("{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula
    (@PathVariable Long codigo, @RequestBody ModPeliculaDto modPeliculaDto){
        return ResponseEntity.ok(this.peliculaService.modificarPelicula(codigo, modPeliculaDto));
    }

    // Eliminar película
    @DeleteMapping("{codigo}")
    public ResponseEntity<PeliculaDto> eliminarPelicula(@PathVariable Long codigo){
        this.peliculaService.eliminarPelicula(codigo);
        return ResponseEntity.ok().build();
    }
    //exception - PeliculaNoExisteException - PeliculaYaExisteException

    //consulta a la IA
    //validaciones (dependencias)
    //documentacion (dependencias)
}
