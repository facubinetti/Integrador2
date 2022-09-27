package DTO;

import java.io.Serializable;
import java.time.LocalTime;

public class CarreraDTO implements Serializable{

	private int idCarrera;
	private String nombreCarrera;
	private int cantInscriptos;
	private int cantEgresados;
	private int inscripcion;
	
	public CarreraDTO() {
	}
		
	public CarreraDTO(int idCarrera, String nombreCarrera, int cantInscriptos, int cantEgresados) {
		super();
		this.idCarrera = idCarrera;
		this.nombreCarrera = nombreCarrera;
		this.cantInscriptos = cantInscriptos;
		this.cantEgresados = cantEgresados;
	}

	//getters y setters
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public int getCantInscriptos() {
		return cantInscriptos;
	}
	public void setCantInscriptos(int cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}
	public int getCantEgresados() {
		return cantEgresados;
	}
	public void setCantEgresados(int cantEgresados) {
		this.cantEgresados = cantEgresados;
	}

	public int getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(int inscripcion) {
		this.inscripcion = inscripcion;
	}
	
}
