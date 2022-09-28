package Controller;


import static java.lang.Integer.parseInt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import DTO.CarreraDTO;
import Factory.*;
import Servicios.*;
import Model.*;

public class Controller {

	private ServicioCarrera sc;
	private ServicioEstudiante se;
	private ServicioMatriculacion sm;
	
	
	public Controller() {
		FactoryEntityManager factoryEntity = new FactoryEntityManager();
		this.sc = new ServicioCarreraImpl(factoryEntity);
		this.se = new ServicioEstudianteImpl(factoryEntity);
		this.sm = new ServicioMatriculacionImpl(factoryEntity);
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
	
	public boolean insertarMatriculacion(Matriculacion m) {
		return this.sm.insertarMatriculacion(m);
	}
	public boolean eliminarMatriculacion(int id) {
		return this.sm.eliminarMatriculacion(id);
	};
	public boolean actualizarMatriculacion(Matriculacion m) {
		return this.sm.actualizarMatriculacion(m);
	};
	
	public boolean insertarCarrera(Carrera c) {
		return this.sc.insertarCarrera(c);
	};

	public boolean actualizarCarrera(Carrera c) {
		if (this.sc.actualizarCarrera(c)) {
			return true;
		} 
		else if (this.insertarCarrera(c)) {
			return true;
		};
		return false;
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
		if(e != null && c != null) {
			Matriculacion mat = new Matriculacion(e,c,false,2020);
			sm.insertarMatriculacion(mat);
			e.agregarMatriculacion(mat);
			c.agregarMatriculacion(mat);
			if(this.actualizarCarrera(c) && this.insertarEstudiante(e)) {
				return true;
			}
		}
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
	
	
	public void cargarDatos() {
		List<Carrera> carreras = leerCarreras();
		try {
			@SuppressWarnings("deprecation")
			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./src/assets/estudiantes100.csv"));
			System.out.println("Estoy cargando los productos...");
			for(CSVRecord row: parser) {
				Estudiante tmp = new Estudiante(parseInt(row.get("dni")),parseInt(row.get("nrolibreta")),row.get("nombre"),row.get("apellido"),parseInt(row.get("edad")),row.get("genero").charAt(0),row.get("ciudad"));
				altaEstudiante(tmp, carreras.get((int) (Math.random()*19+1)));
			}
			System.out.println("No se me da nada mal");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Carrera> leerCarreras(){
		List<Carrera> car = new ArrayList<>();
		try {
			@SuppressWarnings("deprecation")
			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./src/assets/carreras20.csv"));
			System.out.println("Estoy cargando los productos...");
			for(CSVRecord row: parser) {
				Carrera tmp = new Carrera(row.get("nombre"),parseInt(row.get("duracion")));
				car.add(tmp);
			}
			System.out.println("No se me da nada mal");
			return car;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}

}
