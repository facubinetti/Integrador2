package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matricularEstudiante(Estudiante e, Carrera c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Estudiante> getEstudiantesPorCiudad(String nombreCarrera,String ciudad) {
		String get= "SELECT e FROM Estudiante e "
				+ "INNER JOIN Matriculacion m ON e.id_estudiante = m.estudiante INNER JOIN Carrera c ON c.id_carrera  = m.carrera WHERE c.nombre = :carrera "
				+ "AND e.ciudad  = :ciudad";
		Query typedQuery = this.em.createQuery(get);
		typedQuery.setParameter("carrera", nombreCarrera);
		typedQuery.setParameter("ciudad", ciudad);
		return typedQuery.getResultList();	
	}

}
