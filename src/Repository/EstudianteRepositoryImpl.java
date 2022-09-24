package Repository;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Estudiante;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class EstudianteRepositoryImpl implements EstudianteRepository{

	private EntityManager em;
	
	public EstudianteRepositoryImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public boolean saveEstudiante(Estudiante e) {
		if (e.getId_estudiante()  < 1) {
			em.persist(e);
			return true;
		} else {
			e = em.merge(e);
			return false;
		}
	}
	
	@Override
	public Estudiante getEstudiantePorNroLibreta(int lu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> getEstudiantesPorGenero(char genero) {
		String get ="\"SELECT e FROM Estudiante e WHERE e.genero=:genero\"";
		TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
		typedQuery.setParameter("genero", genero);
		return typedQuery.getResultList();
	}

	@Override
	public List<Estudiante> getEstudiantesOrdenadoPor() {
		// TODO Auto-generated method stub
		return null;
	}

}
