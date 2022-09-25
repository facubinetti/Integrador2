package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Carrera;

public class CarreraRepositoryImpl implements CarreraRepository{
	private EntityManager em;

	public CarreraRepositoryImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public boolean saveCarrera(Carrera c) {
		if (c.getId_carrera()  < 1) {
			em.persist(c);
			return true;
		} else {
			c = em.merge(c);
			return false;
		}	
	}

	@Override
	public boolean deleteCarrera(Carrera c) {
		if (em.contains(c)) {
			em.remove(c);
			return true;
		} else {
			em.merge(c);
			return false;
		}
	}
	
	public boolean actualizarCarrera(Carrera c) {
		if(em.contains(c)) {
			em.merge(c);
			return true;
		}else {
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
	        em.close();
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
	        em.close();
		}
		return null;
	}
	
	


}
