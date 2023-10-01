package com.forum.angel27.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarCurso(
        @NotBlank
        String curso
) { }
