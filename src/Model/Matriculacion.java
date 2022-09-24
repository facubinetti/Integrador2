package Model;

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

    @Column
    private boolean graduado;
    
    @Column(name="antiguedad_en_carrera")
    private int antiguedad;

	public Matriculacion() {
	}

	public Matriculacion(Estudiante estudiante, Carrera carrera, boolean graduado, int antiguedad) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.graduado = graduado;
		this.antiguedad = antiguedad;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
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

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	@Override
	public String toString() {
		return "Matriculacion [idcurso=" + idMatricula + ", estudiante=" + estudiante + ", carrera=" + carrera
				+ ", graduado=" + graduado + ", antiguedad=" + antiguedad + "]";
	}


}
