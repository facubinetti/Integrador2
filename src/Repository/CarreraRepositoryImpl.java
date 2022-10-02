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
		String get="SELECT c FROM Carrera c "
				+ "LEFT OUTER JOIN Matriculacion m ON c.id_carrera = m.carrera "
				+ "GROUP BY c.id_carrera,c.nombre ,c.duracion "
				+ "HAVING COUNT(c.id_carrera) > 0 "
				+ "ORDER BY COUNT(c.id_carrera) DESC ";
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
	
	public List<CarreraDTO>  getReporteCarrerasInscriptos() {
		
		String getInscriptos= "SELECT new DTO.CarreraDTO (c.id_carrera AS idCarrera, c.nombre AS nombreCarrera, "
				+ "CAST(COUNT(e.id_estudiante) AS int) AS cantInscriptos, 0 AS cantEgresados, "
				+ "m.anioInscripcion AS anioInscripcion, "
				+ "m.anioGraduado AS anioGraduado) "
				+ "from Carrera c "
				+ "left outer join Matriculacion m on c.id_carrera = m.carrera "
				+ "left outer join Estudiante e on m.estudiante = e.id_estudiante "
				+ "group by m.anioInscripcion,c.id_carrera, c.nombre "
				+ "ORDER BY c.nombre, anioInscripcion, c.id_carrera, cantInscriptos, cantEgresados ASC ";
		
		try { 
			em.getTransaction().begin();
			List<CarreraDTO> listaDTO = this.em.createQuery(getInscriptos, CarreraDTO.class).getResultList();
			return listaDTO;
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
	        em.getTransaction().commit();
		}
		return null;
	}
	
	public List<CarreraDTO>  getReporteCarrerasEgresados() {
		
		String getInscriptos= "SELECT new DTO.CarreraDTO (c.id_carrera AS idCarrera, c.nombre AS nombreCarrera, "
				+ "0 AS cantInscriptos, "
				+ "CAST(COUNT(e.id_estudiante) AS int) AS cantEgresados, "
				+ "m.anioInscripcion AS anioInscripcion, "
				+ "m.anioGraduado AS anioGraduado"
				+ ") "
				+ "from Carrera c "
				+ "left outer join Matriculacion m on c.id_carrera = m.carrera "
				+ "left outer join Estudiante e on m.estudiante = e.id_estudiante "
				+ "group by m.anioGraduado,c.id_carrera, c.nombre "
				+ "ORDER BY c.nombre, anioGraduado, c.id_carrera, cantEgresados ASC ";
		
		try { 
			em.getTransaction().begin();
			List<CarreraDTO> listaDTO = this.em.createQuery(getInscriptos, CarreraDTO.class).getResultList();
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
