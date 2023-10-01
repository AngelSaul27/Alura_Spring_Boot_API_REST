package com.forum.angel27.controller;

import com.forum.angel27.domain.categoria.*;
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
@RequestMapping("/categoria")
@SuppressWarnings("all")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    @Operation(summary = "Listado de las categorias existentes en la BDD")
    public ResponseEntity<Page<DatosCategoria>>
        listadoCategoria(@PageableDefault (size = 2)Pageable pag)
    {
        return ResponseEntity.ok(
            repository.findAll(pag).map(DatosCategoria::new)
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalles de una categoria en particular")
    public ResponseEntity<DatosCategoria> detalleCategoria(@PathVariable Long id){
        var categoria = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosCategoria(categoria));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualizar información de la categoria")
    public void actualizarCategoria(@RequestBody @Valid DatosActualizarCategoria actualizar){
        var categoria = repository.getReferenceById(actualizar.cat_id());
        categoria.actualizar(actualizar);
    }

    @PostMapping
    @Operation(summary = "Agregar nueva categoria a la BDD")
    public ResponseEntity<DatosRegistrarCategoria>
        agregarCategoria(@RequestBody @Valid DatosRegistrarCategoria registro, UriComponentsBuilder uriComponentsBuilder)
    {
        Categoria categoria = repository.save(new Categoria(registro));
        URI url = uriComponentsBuilder.path("/categoria/{id}").buildAndExpand(categoria.getCat_id()).toUri();
        return ResponseEntity.created(url).body(registro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar categoria de la BDD")
    public void eliminarCategoria(@PathVariable Long id){
        Categoria categoria = repository.getReferenceById(id);
        repository.delete(categoria);
    }
}
