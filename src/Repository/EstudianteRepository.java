package Repository;

import java.util.List;

import Model.Carrera;
import Model.Estudiante;

public interface EstudianteRepository {
	
	public boolean saveEstudiante(Estudiante e); //dar de alta un estudiante
	public Estudiante getEstudiantePorNroLibreta(int lu);
	public List<Estudiante> getEstudiantesPorGenero(String genero);
	public List<Estudiante> getEstudiantesOrdenadoPor();//criterio de ordenamiento

}
