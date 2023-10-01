package com.forum.angel27.controller;

import com.forum.angel27.domain.curso.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso")
@SuppressWarnings("all")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    @Operation(summary = "Listado de cursos")
    public ResponseEntity<Page<DatosListadoCurso>>
        listadoCurso(@PageableDefault (size = 2)Pageable pag)
    {
        return ResponseEntity.ok(
            repository.findAll(pag).map(DatosListadoCurso::new)
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalles de una curso en particular")
    public ResponseEntity<DatosListadoCurso> detallesCurso(@PathVariable Long id)
    {
        var curso = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoCurso(curso));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualizar un curso")
    public void actualizarCurso(@RequestBody @Valid DatosActualizarCurso actualizar)
    {
        var curso = repository.getReferenceById(actualizar.cur_id());
        curso.actualizar(actualizar);
    }

    @PostMapping
    @Operation(summary = "Agregar nuevo curso a la BDD")
    public ResponseEntity<DatosRegistrarCurso>
        registrarCurso(@RequestBody @Valid DatosRegistrarCurso registro, UriComponentsBuilder uriComponentsBuilder)
    {
        Curso curso = repository.save(new Curso(registro));
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getCur_id()).toUri();
        return ResponseEntity.created(url).body(registro);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Eliminar curso")
    public void eliminarCurso(@PathVariable Long id)
    {
        Curso curso = repository.getReferenceById(id);
        repository.delete(curso);
    }
}
