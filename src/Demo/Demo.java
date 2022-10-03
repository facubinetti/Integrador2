package Demo;

import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Hibernate;

import Controller.Controller;
import DTO.CarreraDTO;
import Model.Carrera;
import Model.Estudiante;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Demo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
   
		Controller controller = new Controller();
		
		/**
		 * Crear la base de datos Derby y cargarla con datos
		 */
//		controller.cargarDatos();
     
		/**
		 * dar de alta un estudiante y matricular un estudiante en una carrera
		 */
//		 Estudiante e= new Estudiante(39290709,222333, "Pedro", "Perez", 30, 'm', "Balcarce" );
//         Carrera c= controller.getCarrera(4);
//         System.out.println("El alta del estudiante y su matricuacion fue: "+controller.altaEstudiante(e, c));

		/**
		 * recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple (Apellido y nombre)
		 */
//		List<Estudiante> estudiantesOrdenados = controller.getEstudianteOrdenado();
//		for(int i=0; i<estudiantesOrdenados.size(); i++) {
//			System.out.println(estudiantesOrdenados.get(i));
//		}
     
		/**
		 * recuperar un estudiante, en base a su número de libreta universitaria
		 */
		//System.out.println(controller.getEstudianteLibreta(222333));
     
		/**
		 * recuperar todos los estudiantes, en base a su género
		 */
//		List<Estudiante> estudiantesPorGenero = controller.getEstudiantesPorGenero('F');
//		for(int i=0; i<estudiantesPorGenero.size(); i++) {
//			System.out.println(estudiantesPorGenero.get(i));
//		}

		/**
		 * recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos
		 */
//		List<Carrera> listCarrerasConInscriptos= controller.getCarrerasConEstudiantes();
//		for(int i=0; i< listCarrerasConInscriptos.size(); i++) {
//			System.out.println(listCarrerasConInscriptos.get(i));	
//		}	     
     
		/**
		 * recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
		 */
//		List<Estudiante> listEstudiantesPorCarreraYCiudad= controller.getEstudiantePorCiudad("Account Representative III", "Balcarce");
//	 	for(int i=0; i< listEstudiantesPorCarreraYCiudad.size(); i++) {
//	     	System.out.println(listEstudiantesPorCarreraYCiudad.get(i));	
//	     }
     
	   /**
	    * Generar un reporte de las carreras, que para cada carrera incluya información de los
		inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
		los años de manera cronológica. 
	    */
//	 	List<CarreraDTO> reporteCarreras= controller.getReporteCarreras();
//	 	System.out.println("tamanio" + reporteCarreras.size());
//	 	for(int i=0; i< reporteCarreras.size(); i++) {
//		     System.out.println(reporteCarreras.get(i));	
//	 	}
 
	 	em.getTransaction().commit();
	 	em.close();
	 	emf.close();
    }
	
 
}


