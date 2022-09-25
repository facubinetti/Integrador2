package Repository;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Carrera;
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
	public boolean deleteEstudiante(Estudiante e) {
		if (em.contains(e)) {
			em.remove(e);
			return true;
		} else {
			em.merge(e);
			return false;
		}
	}
	
	public boolean actualizarEstudiante(Estudiante e) {
		if(em.contains(e)) {
			em.merge(e);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Estudiante getEstudiantePorNroLibreta(int nrolibreta) {
		String get ="SELECT e FROM Estudiante e WHERE e.nrolibreta=:nrolibreta";
		TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
		typedQuery.setParameter("nrolibreta", nrolibreta);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> getEstudiantesPorGenero(char genero) {
		String get ="SELECT e FROM Estudiante e WHERE e.genero=:genero";
		TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
		typedQuery.setParameter("genero", genero);
		return typedQuery.getResultList();
	}

	@Override
	public List<Estudiante> getEstudiantesOrdenadoPor() {
		String get ="SELECT e FROM Estudiante e ORDER BY e.nombre DESC";
		TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<Estudiante> getAllEstudiantes() {
		String get="SELECT e FROM Estudiante e";
		TypedQuery<Estudiante> typedQuery = this.em.createQuery(get, Estudiante.class);
		return typedQuery.getResultList();
	}

}
