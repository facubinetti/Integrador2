package Repository;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Carrera;
import Model.Estudiante;

public class CarreraRepositoryImpl implements CarreraRepository{
	private EntityManager em;

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
	public List<Estudiante> getEstudiantesPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

}
