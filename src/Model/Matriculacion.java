package Model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.*;


@Entity
public class Matriculacion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante") //FK
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera") //FK
    private Carrera carrera;

    @Column(name="graduado")
    private boolean graduado;
    
//    @Column(name = "local_date", columnDefinition = "DATE")
//    private LocalDate inscripcion;
    
    @Column(name="anioInscripcion")
    private int anioInscripcion;

	public Matriculacion() {
	}

	public Matriculacion(Estudiante estudiante, Carrera carrera, boolean graduado, int inscripcion) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.graduado = graduado;
		this.anioInscripcion = inscripcion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public String getNombreCarrera() {
		return this.carrera.getNombre();
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public int getIdMatricula() {
		return idMatricula;
	}
	
	public int getInscripcion() {
		return anioInscripcion;
	}

	public void setInscripcion(int inscripcion) {
		this.anioInscripcion = inscripcion;
	}

	@Override
	public String toString() {
		return "Matriculacion [idcurso=" + idMatricula + ", estudiante=" + estudiante + ", carrera=" + carrera
				+ ", graduado=" + graduado  + "]";
	}


}
