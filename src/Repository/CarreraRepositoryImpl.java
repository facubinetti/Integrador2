package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Carrera;
import Model.Estudiante;

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

	@Override
	public List<Carrera> getCarrerasConEstudiantes() {
		String get="SELECT DISTINCT c FROM Carrera c JOIN c.matriculaciones m WHERE SIZE(c.matriculaciones) > 0 ";
		TypedQuery<Carrera> typedQuery = this.em.createQuery(get, Carrera.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<Estudiante> getEstudiantesPorCiudad(String nombreCarrera,String ciudad) {
		String get= "SELECT e FROM Estudiante e "
				+ "INNER JOIN Matriculacion m ON e.id_estudiante = m.estudiante "
				+ "INNER JOIN Carrera c ON c.id_carrera  = m.carrera "
				+ "WHERE c.nombre = :carrera "
				+ "AND e.ciudad  = :ciudad";
		TypedQuery<Estudiante> typedQuery = this.em.createQuery(get, Estudiante.class);
		typedQuery.setParameter("carrera", nombreCarrera);
		typedQuery.setParameter("ciudad", ciudad);
		return typedQuery.getResultList();	
	}

	@Override
	public List<Carrera> getAllCarreras() {
		String get="SELECT c FROM Carrera c";
		TypedQuery<Carrera> typedQuery = this.em.createQuery(get, Carrera.class);
		return typedQuery.getResultList();
	}
	
	


}
