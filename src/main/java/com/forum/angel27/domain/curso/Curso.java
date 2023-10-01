package com.forum.angel27.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cur_id")
@SuppressWarnings("all")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cur_id;
    private String curso;

    public Curso(DatosRegistrarCurso datos){
        this.curso = datos.curso();
    }

    public void actualizar(DatosActualizarCurso datos){
        if(datos.curso() != null){
            this.curso = datos.curso();
        }
    }
}
