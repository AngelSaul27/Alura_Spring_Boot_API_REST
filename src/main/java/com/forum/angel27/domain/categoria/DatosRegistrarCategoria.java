package com.forum.angel27.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarCategoria(
        @NotBlank
        String categoria
) { }
