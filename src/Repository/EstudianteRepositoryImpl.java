package Repository;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Estudiante;

public class EstudianteRepositoryImpl implements EstudianteRepository{

	private EntityManager em;
	
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
	public List<Estudiante> getEstudiantesPorGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> getEstudiantesOrdenadoPor() {
		// TODO Auto-generated method stub
		return null;
	}

}
