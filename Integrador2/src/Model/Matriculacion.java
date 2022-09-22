package Model;

import javax.persistence.*;


@Entity
public class Matriculacion {
    @Id
    int idcurso;

    @ManyToOne
    Estudiante estudiante;

    int idcarrera;

    boolean graduado;


}
