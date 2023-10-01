package com.forum.angel27.domain.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cat_id")
@SuppressWarnings("all")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;
    private String categoria;

    public Categoria(DatosRegistrarCategoria datos){
        this.categoria = datos.categoria();
    }

    public void actualizar(DatosActualizarCategoria datos){
        if(datos.categoria() != null){
            this.categoria = datos.categoria();
        }
    }
}
