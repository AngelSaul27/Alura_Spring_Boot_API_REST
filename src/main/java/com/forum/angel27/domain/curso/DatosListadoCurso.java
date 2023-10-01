package com.forum.angel27.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosListadoCurso(
        @NotNull
        Long cur_id,
        @NotBlank
        String curso
) {
        public DatosListadoCurso(Curso curso){
               this(curso.getCur_id(), curso.getCurso());
        }
}