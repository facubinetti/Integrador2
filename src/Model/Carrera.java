package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    int id_carrera;

    @Column(nullable=false)
    String nombre;

    @OneToMany(mappedBy = "carrera",fetch = FetchType.EAGER)
    List<Matriculacion> matriculaciones;
    
    //Constructores
	public Carrera( String nombre) {
		this.nombre = nombre;
		this.matriculaciones = new ArrayList<Matriculacion>();
	}

	public Carrera() {
	}

	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		nombre = nombre;
	}

	public int getId_carrera() {
		return id_carrera;
	}

	public void agregarMatriculacion(Matriculacion mat){
		matriculaciones.add(mat);
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", nombre=" + nombre + ", matriculaciones=" + matriculaciones.size()
				+ "]";
	}

}
