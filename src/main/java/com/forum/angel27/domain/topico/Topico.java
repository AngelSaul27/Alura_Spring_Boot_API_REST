package com.forum.angel27.domain.topico;

import com.forum.angel27.domain.categoria.Categoria;
import com.forum.angel27.domain.categoria.CategoriaRepository;
import com.forum.angel27.domain.curso.Curso;
import com.forum.angel27.domain.curso.CursoRepository;
import com.forum.angel27.domain.curso.DatosRegistrarCurso;
import com.forum.angel27.domain.usuario.Usuario;
import com.forum.angel27.domain.usuario.UsuarioRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "top_id")
@SuppressWarnings("all")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long top_id;
    private String titulo;
    private String mensaje;
    private Boolean estatus;
    private String fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "cur_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private Usuario usuario;

    public Topico(DatosRegistrarTopico value){
        this.titulo = value.titulo();
        this.mensaje = value.mensaje();
        this.estatus = value.estatus();
        this.fecha_creacion = value.fecha_creacion();
        this.categoria = value.categoria();
        this.curso = value.curso();
        this.usuario = value.usuario();
    }

    public void actualizar(DatosActualizarTopico datos){
        if(datos.titulo() != null ){
            this.titulo = datos.titulo();
        }

        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }

        if(datos.estatus() != null){
            this.estatus = datos.estatus();
        }
    }
}
