package Repository;

import java.util.List;

import javax.persistence.EntityManager;


import Model.Estudiante;

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
		try {
			em.getTransaction().begin();
			TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
			typedQuery.setParameter("nrolibreta", nrolibreta);
			return typedQuery.getSingleResult();
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
	public List<Estudiante> getEstudiantesPorGenero(char genero) {
		String get ="SELECT e FROM Estudiante e WHERE e.genero=:genero";
		try {
			em.getTransaction().begin();
			TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
			typedQuery.setParameter("genero", genero);
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
	public List<Estudiante> getEstudiantesOrdenadoPor() {
		String get ="SELECT e FROM Estudiante e ORDER BY e.nombre DESC";
		try {
			em.getTransaction().begin();
			TypedQuery<Estudiante> typedQuery = this.em.createQuery(get,Estudiante.class);
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
	public List<Estudiante> getAllEstudiantes() {
		String get="SELECT e FROM Estudiante e";
		try {
			em.getTransaction().begin();
			TypedQuery<Estudiante> typedQuery = this.em.createQuery(get, Estudiante.class);
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
	public List<Estudiante> getEstudiantesPorCiudad(String nombreCarrera,String ciudad) {
		String get = "SELECT e FROM Estudiante e "
				+ "INNER JOIN Matriculacion m ON e.id_estudiante = m.estudiante "
				+ "INNER JOIN Carrera c ON c.id_carrera  = m.carrera "
				+ "WHERE c.nombre = :carrera "
				+ "AND e.ciudad  = :ciudad";
		try {
			em.getTransaction().begin();
			TypedQuery<Estudiante> typedQuery = this.em.createQuery(get, Estudiante.class);
			typedQuery.setParameter("carrera", nombreCarrera);
			typedQuery.setParameter("ciudad", ciudad);
			return typedQuery.getResultList();	
		}catch(Exception e){
			e.printStackTrace();
		}finally {
	        em.getTransaction().commit();
	        em.close();
		}
		return null;
	}

}
