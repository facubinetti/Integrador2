package Controller;


import java.time.LocalDate;
import java.util.List;

import DTO.CarreraDTO;
import Factory.*;
import Servicios.*;
import Model.*;

public class Controller {

	private ServicioCarrera sc;
	private ServicioEstudiante se;
	
	
	public Controller() {
		FactoryEntityManager factoryEntity = new FactoryEntityManager();
		this.sc = new ServicioCarreraImpl(factoryEntity);
		this.se = new ServicioEstudianteImpl(factoryEntity);
	};
	
	
	public boolean insertarEstudiante(Estudiante e) {
		return this.se.insertarEstudiante(e);
	}
	public boolean eliminarEstudiante(int id) {
		return this.se.eliminarEstudiante(id);
	};
	public boolean actualizarEstudiante(Estudiante e) {
		return this.se.actualizarEstudiante(e);
	};
	
	public boolean insertarCarrera(Carrera c) {
		return this.sc.insertarCarrera(c);
	};

	public boolean actualizarCarrera(Carrera c) {
		return this.sc.actualizarCarrera(c);
	};
	
	public boolean eliminarCarrera(int id){
		return this.sc.eliminarCarrera(id);
	};
	
	
	public List<Carrera> listarCarreras(){
		return this.sc.listarCarreras();
	};
	
	public Carrera getCarrera(int id) {
		return this.sc.getCarrera(id);
	}
	
	public List<Carrera> getCarrerasConEstudiantes(){
		return this.sc.getCarrerasConEstudiantes();
	};
	
	
	public boolean altaEstudiante(Estudiante e, Carrera c) {
		Matriculacion m = new Matriculacion(e,c,false, 2020 );
		e.agregarMatriculacion(m);
		c.agregarMatriculacion(m);
		if(actualizarCarrera(c)&&insertarEstudiante(e))
			return true;
		return false;
	}
	
	public List<Estudiante> getAllEstudiantes(){
		return this.se.obtenerAllEstudiantes();
	}
	
	public List<Estudiante> getEstudiantesPorGenero(char genero){
		return this.se.getEstudiantesPorGenero(genero);
	}
	
	public Estudiante getEstudianteLibreta(int nroLibreta) {
		return this.se.getEstudiantePorNroLibreta(nroLibreta);
	}
	
	public List<Estudiante> getEstudianteOrdenado(){
		return this.se.getEstudiantesOrdenadoPorApellidoYNombre();
	}
	
	public List<Estudiante> getEstudiantePorCiudad(String carrera, String ciudad){
		return this.se.getEstudiantesPorCiudad(carrera, ciudad);
	}
	
	public List<CarreraDTO> getReporteCarreras(){
		return this.sc.getReporteCarreras();
	}
	
}
