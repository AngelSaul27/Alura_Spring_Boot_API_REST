package com.forum.angel27.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCategoria(
   @NotNull
   Long cat_id,
   @NotBlank
   String categoria
) {
   public DatosCategoria(Categoria categoria) {
       this(categoria.getCat_id(), categoria.getCategoria());
   }
}
