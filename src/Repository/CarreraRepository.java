package Repository;

import java.util.List;

import Model.Carrera;
import Model.Estudiante;

public interface CarreraRepository {
	
	public boolean saveCarrera(Carrera c);
	public boolean deleteCarrera(Carrera c);
	public boolean matricularEstudiante(Estudiante e, Carrera c); 
	public List<Carrera> getCarrerasConEstudiantes();
	public List<Estudiante> getEstudiantesPorCiudad(String ciudad);
}
