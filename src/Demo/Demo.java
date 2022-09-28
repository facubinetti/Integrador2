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
//

////

////
////        
//        Matriculacion mat1 = new Matriculacion(est1,car1,false, 2020);
//        Matriculacion mat2 = new Matriculacion(est2,car1,true, 2020 );
//        Matriculacion mat3 = new Matriculacion(est2,car2,true,2021);
//
//////        estudiante 1
//        est1.agregarMatriculacion(mat1);
//        car1.agregarMatriculacion(mat1);
//        car2.agregarMatriculacion(mat3);
////
//////        estudiante 2
//        est2.agregarMatriculacion(mat2);
//        car1.agregarMatriculacion(mat2);
////
//        em.persist(est1);
//        em.persist(est2);
//        em.persist(car1);
//        em.persist(car2);
//        em.persist(car3);
//        em.persist(mat1);
//        em.persist(mat2);
//        em.persist(mat3);
       
  //     CarreraRepositoryImpl cri = new CarreraRepositoryImpl(em);
////        List<Estudiante> listE= cri.getEstudiantesPorCiudad("TUDAI", "Tres Arroyos");
////        for(int i=0; i< listE.size(); i++) {
////        	System.out.println(listE.get(i));	
////        	
////        }
////        
////        System.out.println("----------------------------------------------------"); 
//        //imprimir estudiantes ordenados por alguna propiedad
//       EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
////        List<Estudiante> listE2= eri.getEstudiantesOrdenadoPor();
////        for(int i=0; i< listE2.size(); i++) {
////        	System.out.println(listE2.get(i));	
////        	
////        }
////        System.out.println("----------------------------------------------------");
////        System.out.println(eri.getEstudiantePorNroLibreta(0));
//       	List<Carrera> listE2= cri.getCarrerasConEstudiantes();
//	     for(int i=0; i< listE2.size(); i++) {
//	     	System.out.println(listE2.get(i));	
//	     	
//	     }
        
      
//       
//     Estudiante est1 = new Estudiante(1,1,"Juan","Perez",26,'M',"Tres Arroyos");
//     Estudiante est2 = new Estudiante(2,2,"Manuela","Ruiz",26,'F',"Tres Arroyos");
//     
//     Carrera car1 = new Carrera("TUDAI", 3);
//     Carrera car2 = new Carrera("Ingenieria en Sistemas", 5);
//     Carrera car3 = new Carrera("Contador", 6); // sin matri
//     
//     Matriculacion mat1 = new Matriculacion(est1,car1,false,2022);
//     car1.agregarMatriculacion(mat1);
//     est1.agregarMatriculacion(mat1);
//     
//     em.persist(car1);
//     em.persist(est1);
//     em.persist(mat1);
     
//     controller.altaEstudiante(est2, car1);
//     controller.altaEstudiante(est1, car3);
//     controller.altaEstudiante(est1, car3);
     
     
     Controller controller = new Controller();
     controller.cargarDatos();
       
//        List<Carrera> listE2= controller.getCarrerasConEstudiantes();
//	     for(int i=0; i< listE2.size(); i++) {
//	     	System.out.println(listE2.get(i));	
//	     }
       
//      	cargarDatos(controller);
	     
//        
       em.getTransaction().commit();
       em.close();
       emf.close();
    	
    	
    	
    	
    	
//    	Estudiante e = new Estudiante(43304272,150752,"Benjamin","Aldaya",21,'M',"Tres arroyos");
    	
//    	Carrera carrera = controller.getCarrera(5);

    	
//    	Carrera carrera = controller.getCarrera(1);
//    	
//   	controller.altaEstudiante(e, carrera);
    	
    	
//   	System.out.println(controller.eliminarEstudiante(401));
//    	
    	//Estudiante e = new Estudiante(42204279,131522,"Perez","Soledad",22,'F',"Tres arroyos");
   // 	controller.insertarEstudiante(e);

//    	Carrera carrera = controller.getCarrera(4);
//    	controller.altaEstudiante(e, carrera);  
    	
    	
//    	List<Estudiante> estudiantes = controller.getAllEstudiantes();
//    	for(Estudiante est: estudiantes) {
//    		System.out.println(est);
//    	}
    }
    
    
}


