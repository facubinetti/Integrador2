package Servicios;

import java.util.List;

import Model.Estudiante;

public interface ServicioEstudiante {

	public boolean insertarEstudiante(Estudiante e);
	public List<Estudiante> obtenerAllEstudiantes();
	public boolean eliminarEstudiante(Estudiante e);
	public boolean actualizarEstudiante(Estudiante e);
	public Estudiante getEstudiantePorNroLibreta(int lu);
	public List<Estudiante> getEstudiantesPorGenero(char genero);
	public List<Estudiante> getEstudiantesOrdenadoPor();//criterio de ordenamiento
	public List<Estudiante> getEstudiantesPorCiudad(String nombreCarrera, String ciudad);
}
