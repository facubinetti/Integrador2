package Servicios;

import java.util.List;

import Model.Carrera;
import Model.Estudiante;

public interface ServicioEstudiante {

	public boolean insertarEstudiante(Estudiante e);
	public List<Estudiante> listarEstudiante();
	public boolean eliminarEstudiante(Estudiante e);
	public boolean actualizarEstudiante(Estudiante e);
	public List<Estudiante> getEstudiantesPorGenero(char genero);
	public List<Estudiante> getEstudiantesOrdenadoPor();//criterio de ordenamiento
}
