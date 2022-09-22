package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Estudiante {

    public Estudiante(int nrolibreta, int dni, String nombre, String apellido, int edad,
                      char genero, String ciudad, List<Matriculacion> crusos) {
        this.nrolibreta = nrolibreta;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.cursos = cursos;
    }

    public Estudiante() {
    }

    @Id
    int id_estudiante;

    @Column(name = "dni")
    int dni;

   @Column
   @GeneratedValue(strategy = GenerationType.AUTO)
    int nrolibreta;

    @Column(name = "nombre",nullable = false)
    String nombre;

    @Column(name = "apellido",nullable = false)
    String apellido;

    @Column(name = "edad",nullable = false)
    int edad;

    @Column(name = "genero",nullable = false)
    char genero;

    @Column(name = "ciudad",nullable = false)
    String ciudad;

    @OneToMany (mappedBy = "estudiante",fetch = FetchType.LAZY)
    List<Matriculacion> cursos;



}
