package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Estudiante {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    int id_estudiante;

    @Column(name = "dni")
	@GeneratedValue(strategy=GenerationType.AUTO)
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
    List<Matriculacion> matriculaciones;

    public Estudiante( String nombre, String apellido, int edad,
            char genero, String ciudad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.matriculaciones = new ArrayList<Matriculacion>() ;
	}

	public Estudiante() {
	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNrolibreta() {
		return nrolibreta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Matriculacion> getMatriculaciones() {
		return matriculaciones;
	}

	public void agregarMatriculacion(Matriculacion mat){
		matriculaciones.add(mat);
	}
	
	

}
