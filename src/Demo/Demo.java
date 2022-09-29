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

import Model.Carrera;
import Model.Estudiante;
import Model.Matriculacion;
import Repository.CarreraRepositoryImpl;
import Repository.EstudianteRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    // controller.cargarDatos();
     
     //dar de alta un estudiante
     
     
     //matricular un estudiante en una carrera
     
     //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
     
     //recuperar un estudiante, en base a su número de libreta universitaria
     
     //recuperar todos los estudiantes, en base a su género
          
     //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos
     List<Carrera> listCarrerasConInscriptos= controller.getCarrerasConEstudiantes();
     for(int i=0; i< listCarrerasConInscriptos.size(); i++) {
	     	System.out.println(listCarrerasConInscriptos.get(i));	
	     }
	     
     
     //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
     
        
       em.getTransaction().commit();
       em.close();
       emf.close();
    	
   
    }
    
    
}


