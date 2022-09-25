package Servicios;

import java.util.List;

import Model.Estudiante;
import Repository.EstudianteRepositoryImpl;

public class ServicioEstudianteImpl implements ServicioEstudiante{
	private EstudianteRepositoryImpl er;
	
	@Override
	public boolean insertarEstudiante(Estudiante e) {
		return er.saveEstudiante(e);
	}

	@Override
	public List<Estudiante> listarEstudiante() {
		return er.getAllEstudiantes();
	}

	@Override
	public boolean eliminarEstudiante(Estudiante e) {
		return er.deleteEstudiante(e);
	}

	@Override
	public List<Estudiante> getEstudiantesPorGenero(char genero) {
		return er.getEstudiantesPorGenero(genero);
	}

	@Override
	public List<Estudiante> getEstudiantesOrdenadoPor() {
		return er.getEstudiantesOrdenadoPor();
	}

}
