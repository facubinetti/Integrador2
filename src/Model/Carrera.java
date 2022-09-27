package Model;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_carrera;

    @Column(nullable=false)
    private String nombre;
    
    @Column
    private int duracion;

    @OneToMany(mappedBy = "carrera",fetch = FetchType.LAZY)
    private List<Matriculacion> matriculaciones;
    
    //Constructores
	public Carrera( String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion=duracion;
		this.matriculaciones = new ArrayList<Matriculacion>();
	}

	public Carrera() {
	}

	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_carrera() {
		return id_carrera;
	}

	public void agregarMatriculacion(Matriculacion mat){
		matriculaciones.add(mat);
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", nombre=" + nombre + ", duracion=" + duracion + ", matriculaciones=" + matriculaciones.size()
				+ "]";
	}

}
