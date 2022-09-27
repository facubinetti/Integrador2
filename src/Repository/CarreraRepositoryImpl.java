package Repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import DTO.CarreraDTO;
import Model.Carrera;
import Model.Estudiante;


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
		String get="SELECT DISTINCT c "
				+ "FROM Carrera c LEFT OUTER JOIN c.matriculaciones m "
				+ "WHERE SIZE(c.matriculaciones) > 0 "
			//	+ "ORDER BY SIZE(c.matriculaciones), c.id_carrera, c.nombre, c.duracion DESC "; //No se puede ordenar por SIZE(). Ordenar en java???
		;
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
	
	public List<CarreraDTO>  getReporteCarreras() {
		
		String get= "SELECT new DTO.CarreraDTO (c.id_carrera AS idCarrera, c.nombre AS nombreCarrera, COUNT(e.id_estudiante) AS cantInscriptos, "
				+ "COUNT(CASE WHEN (m.graduado = :trueValue) THEN 1 END) AS cantEgresados, CAST(m.anioInscripcion AS long) AS anioInscripcion) "
				+ "from Carrera c "
				+ "left outer join Matriculacion m on c.id_carrera = m.carrera "
				+ "left outer join Estudiante e on m.estudiante = e.id_estudiante "
				+ "group by m.anioInscripcion,c.id_carrera, c.nombre "
				+ "ORDER BY c.nombre, m.anioInscripcion, c.id_carrera, cantInscriptos, cantEgresados ASC";
		try { 
			em.getTransaction().begin();
			List<CarreraDTO> listaDTO = this.em.createQuery(get, CarreraDTO.class).setParameter("trueValue", true).getResultList();
			return listaDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
	        em.getTransaction().commit();
		}
		return null;
	}
	


}
