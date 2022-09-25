package Servicios;

import java.util.List;

import Model.Carrera;
import Model.Estudiante;
import Repository.CarreraRepositoryImpl;

public class ServicioCarreraImpl implements ServicioCarrera{
	private CarreraRepositoryImpl cr;
	
	

	@Override
	public boolean insertarCarrera(Carrera c) {
		return cr.saveCarrera(c);
	}

	@Override
	public List<Carrera> listarCarreras() {
		return cr.getAllCarreras();
	}

	@Override
	public boolean eliminarCarrera(Carrera c) {
		return cr.deleteCarrera(c);
	}

	@Override
	public List<Carrera> getCarrerasConEstudiantes() {
		return cr.getCarrerasConEstudiantes();
	}

	@Override
	public List<Estudiante> getEstudiantesPorCiudad(String nombreCarrera, String ciudad) {
		return cr.getEstudiantesPorCiudad(nombreCarrera, ciudad);
	}

}
