package com.forum.angel27.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long top_id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Boolean estatus
) { }
