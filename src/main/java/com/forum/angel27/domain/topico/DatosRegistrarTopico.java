package com.forum.angel27.domain.topico;

import com.forum.angel27.domain.categoria.Categoria;
import com.forum.angel27.domain.curso.Curso;
import com.forum.angel27.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Boolean estatus,
        @NotBlank
        String fecha_creacion,
        @NotNull
        Categoria categoria,
        @NotNull
        Curso curso,
        @NotNull
        Usuario usuario
) { }
