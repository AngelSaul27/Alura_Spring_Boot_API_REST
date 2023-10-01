package com.forum.angel27.domain.topico;

import com.forum.angel27.domain.categoria.Categoria;
import com.forum.angel27.domain.curso.Curso;
import com.forum.angel27.domain.usuario.Usuario;

public record DatosListadoTopico(
        Long top_id,
        String titulo,
        String mensaje,
        Boolean estatus,
        String fecha_creacion,
        Categoria categoria,
        Curso curso,
        Usuario usuario
) {
    public DatosListadoTopico(Topico value){
        this(
            value.getTop_id(),
            value.getTitulo(),
            value.getMensaje(),
            value.getEstatus(),
            value.getFecha_creacion(),
            value.getCategoria(),
            value.getCurso(),
            value.getUsuario()
        );
    }
}