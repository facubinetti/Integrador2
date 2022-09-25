package Repository;

import java.util.List;

import Model.Carrera;

public interface CarreraRepository {
	
	public boolean saveCarrera(Carrera c);
	public boolean deleteCarrera(Carrera c);
	public boolean actualizarCarrera(Carrera c);
	public Carrera getCarrera(int id);
	public List<Carrera> getAllCarreras();
	public List<Carrera> getCarrerasConEstudiantes();
}
