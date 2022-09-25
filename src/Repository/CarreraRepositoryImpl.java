package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.Carrera;


public class CarreraRepositoryImpl implements CarreraRepository{
	private EntityManager em;

	public CarreraRepositoryImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public boolean saveCarrera(Carrera c) {
		em.getTransaction().begin();
		if (c.getId_carrera()  < 1) {
			em.persist(c);
	        em.getTransaction().commit();
			return true;
		} else {
			c = em.merge(c);
	        em.getTransaction().commit();
			return false;
		}	
	}

	@Override
	public boolean deleteCarrera(int id) {
		String delete = "DELETE FROM Carrera c WHERE e.id_carrera=:id";
		try {
			this.em.getTransaction().begin();
			Query query = this.em.createQuery(delete);
			query.setParameter("id", id).executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.getTransaction().commit();
		}
		return false;
	}
	
	public boolean actualizarCarrera(Carrera c) {
		em.getTransaction().begin();
		if(em.contains(c)) {
			em.merge(c);
	        em.getTransaction().commit();
			return true;
		}else {
	        em.getTransaction().commit();
			return false;
		}
	}

	@Override
	public List<Carrera> getCarrerasConEstudiantes() {
		String get="SELECT DISTINCT c FROM Carrera c JOIN c.matriculaciones m WHERE SIZE(c.matriculaciones) > 0 ";
		try {
			em.getTransaction().begin();
			TypedQuery<Carrera> typedQuery = this.em.createQuery(get, Carrera.class);
			return typedQuery.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
	        em.getTransaction().commit();
		}
		return null;
	}

	@Override
	public List<Carrera> getAllCarreras() {
		String get="SELECT c FROM Carrera c";
		try {
			em.getTransaction().begin();
			TypedQuery<Carrera> typedQuery = this.em.createQuery(get, Carrera.class);
			return typedQuery.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
	        em.getTransaction().commit();
		}
		return null;
	}

	@Override
	public Carrera getCarrera(int id) {
		String get ="SELECT c FROM Carrera c WHERE c.id_carrera=:id";
		try {
			em.getTransaction().begin();
			TypedQuery<Carrera> typedQuery = this.em.createQuery(get,Carrera.class);
			typedQuery.setParameter("id", id);
			return typedQuery.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
	        em.getTransaction().commit();
		}
		return null;
	}
	
	


}
