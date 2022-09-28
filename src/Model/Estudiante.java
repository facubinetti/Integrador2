package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Estudiante {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_estudiante;

    @Column(name = "dni")
	@GeneratedValue
    private int dni;

   @Column
   @GeneratedValue
    private int nrolibreta;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "edad",nullable = false)
    private int edad;

    @Column(name = "genero",nullable = false)
    private char genero;

    @Column(name = "ciudad",nullable = false)
    private String ciudad;

    @OneToMany (mappedBy = "estudiante",fetch = FetchType.LAZY)
    private List<Matriculacion> matriculaciones;

    public Estudiante( int dni, int lu,String nombre, String apellido, int edad ,char genero, String ciudad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.dni = dni;
		this.nrolibreta = lu;
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

	@Override
	public String toString() {
		return "Estudiante [id_estudiante= " + id_estudiante + ", dni= " + dni + ", nrolibreta= " + nrolibreta
				+ ", nombre= " + nombre + ", apellido= " + apellido + ", edad=" + edad + ", genero= " + genero
				+ ", ciudad= " + ciudad +", carrera= "+ this.getCarrera()+" ]";
	}

	private String getCarrera() {
		if(matriculaciones.size() > 0) {
			for(Matriculacion m: matriculaciones) {
				return m.getNombreCarrera();
			}
		}
		return null;
	}
	
	

}
