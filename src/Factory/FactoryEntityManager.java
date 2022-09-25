package Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
    EntityManager em = emf.createEntityManager();
    
    public FactoryEntityManager(){};
    
    public EntityManager getEntityManger() {
    	return this.em;
    }
    
    // Se podrian crear metodos para administrar el entityManager, todos los servicios usarian la misma fabrica, obtendrian el mismo entityManager, 
    // a menos que se cree distintos metodos y se podria limpíar, borrar y abrir nuevos segun se quiera.
}
