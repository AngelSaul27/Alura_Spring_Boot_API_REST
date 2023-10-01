package com.forum.angel27.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso (
        @NotNull
        Long cur_id,
        String curso
){ }
