package com.forum.angel27.domain.categoria;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCategoria(
        @NotNull
        Long cat_id,
        String categoria
) { }
