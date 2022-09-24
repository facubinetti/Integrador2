package Demo;

import Model.Carrera;
import Model.Estudiante;
import Model.Matriculacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Estudiante est1 = new Estudiante("Juan","Perez",26,'M',"Tres Arroyos");
        Estudiante est2 = new Estudiante("Manuela","Perez",26,'F',"Tres Arroyos");

        Carrera car1 = new Carrera("TUDAI");

        Matriculacion mat1 = new Matriculacion(est1,car1,false,4);
        Matriculacion mat2 = new Matriculacion(est2,car1,true,3);

//        estudiante 1
        est1.agregarMatriculacion(mat1);
        car1.agregarMatriculacion(mat1);

//        estudiante 2
        est2.agregarMatriculacion(mat2);
        car1.agregarMatriculacion(mat2);

        em.persist(est1);
        em.persist(est2);
        em.persist(car1);
        em.persist(mat1);
        em.persist(mat2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
