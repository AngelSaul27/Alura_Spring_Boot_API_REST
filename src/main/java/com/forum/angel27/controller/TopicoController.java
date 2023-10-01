package com.forum.angel27.controller;

import com.forum.angel27.domain.topico.*;
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
@RequestMapping("/topico")
@SuppressWarnings("all")
public class TopicoController {

    @Autowired
    TopicoRepository repository;

    @GetMapping
    @Operation(summary = "Lista de Topicos")
    public ResponseEntity<Page<DatosListadoTopico>> listTopico(
        @PageableDefault (size = 2)Pageable pag)
    {
        return ResponseEntity.ok(
            repository.findAll(pag).map(DatosListadoTopico::new)
        );
    }

    @GetMapping("{id}")
    @Operation(summary = "Detalles de un Topico")
    public ResponseEntity<DatosListadoTopico> detalleTopico(@PathVariable Long id)
    {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualizar un Topico")
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico actualizar)
    {
        var topico = repository.getReferenceById(actualizar.top_id());
        topico.actualizar(actualizar);
    }

    @PostMapping
    @Operation(summary = "Agregar un Nuevo Topico")
    public ResponseEntity<DatosRegistrarTopico>
       registrarTopico(@RequestBody @Valid DatosRegistrarTopico registro, UriComponentsBuilder uriComponentsBuilder)
    {
        Topico topico = repository.save(new Topico(registro));
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(topico.getTop_id()).toUri();
        return ResponseEntity.created(url).body(registro);
    }

    @DeleteMapping
    @Operation(summary = "Eliminar un Topico")
    public void eliminarTopico(@PathVariable Long id)
    {
        Topico topico = repository.getReferenceById(id);
        repository.delete(topico);
    }
}
