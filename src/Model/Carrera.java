package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    int id_carrera;

    @Column(nullable=false)
    String Nombre;

    @OneToMany(mappedBy = "carrera",fetch = FetchType.LAZY)
    List<Matriculacion> matriculaciones;
    
    //Constructores
	public Carrera(int id_carrera, String nombre) {
		super();
		this.id_carrera = id_carrera;
		Nombre = nombre;
	}

	public Carrera() {
	}

	//getters y setters
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

    

}
