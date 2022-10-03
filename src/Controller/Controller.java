package Controller;


import static java.lang.Integer.parseInt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public int generateRandomInt(int min, int max){
        return (int) Math.floor((Math.random() * (max+1 -min)) +min);
    }
	
	public boolean altaEstudiante(Estudiante e, Carrera c) {
		if(e != null && c != null) {
			Random random = new Random();
			//40% chance of true
			boolean chances40true = (random.nextInt(5) < 2) ? true : false;
			int anioRandomIngreso=0;//null
			int anioRandomEgreso = 0; 	
			int duracionTemp= c.getDuracion();
			

			if(chances40true) {
				anioRandomIngreso= generateRandomInt(2010, 2022-duracionTemp);
				anioRandomEgreso= generateRandomInt(2022-duracionTemp, 2022);
			}else {
				anioRandomIngreso=generateRandomInt(2010, 2022);
			}
				
			Matriculacion mat = new Matriculacion(e,c,anioRandomEgreso,anioRandomIngreso);
			e.agregarMatriculacion(mat);
			c.agregarMatriculacion(mat);
			if(this.actualizarCarrera(c) && this.insertarEstudiante(e)) {
				sm.insertarMatriculacion(mat);
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
	
	/////////// prueba ---------------------------------
	public List<CarreraDTO> getReporteCarrerasInscriptos(){
		return this.sc.getReporteCarrerasInscriptos();
	}
	
	public List<CarreraDTO> getReporteCarrerasEgresados(){
		return this.sc.getReporteCarrerasEgresados();
	}
	//----------------------------------------------------------------------------------------------
	
	
	public void cargarDatos() {
		List<Carrera> carreras = leerCarreras();
		try {
			@SuppressWarnings("deprecation")
			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("./src/assets/estudiantes100.csv"));
			System.out.println("Estoy cargando los estudiantes...");
			for(CSVRecord row: parser) {
				Estudiante tmp = new Estudiante(parseInt(row.get("dni")),parseInt(row.get("nrolibreta")),row.get("nombre"),row.get("apellido"),parseInt(row.get("edad")),generarGenero(),row.get("ciudad"));
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
			System.out.println("Estoy cargando las carreras...");
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
	
	public char generarGenero() {
		Random random = new Random();
		//50% chance of true
		boolean chances50true = (random.nextInt(4) < 2) ? true : false;
		if(chances50true) {
			return 'f';
		}
		return 'm';
	}

}
