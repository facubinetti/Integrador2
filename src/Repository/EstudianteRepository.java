package Repository;

import java.util.List;

import Model.Estudiante;

public interface EstudianteRepository {
	
	public boolean saveEstudiante(Estudiante e); //dar de alta un estudiante
	public boolean deleteEstudiante(Estudiante e);
	public boolean actualizarEstudiante(Estudiante e);
	public List<Estudiante> getAllEstudiantes();
	public Estudiante getEstudiantePorNroLibreta(int lu);
	public List<Estudiante> getEstudiantesPorGenero(char genero);
	public List<Estudiante> getEstudiantesOrdenadoPor();//criterio de ordenamiento

}
