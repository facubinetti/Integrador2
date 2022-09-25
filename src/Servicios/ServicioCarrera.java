package Servicios;

import java.util.List;

import javax.persistence.EntityManager;

import Model.Carrera;
import Model.Estudiante;
import Repository.*;

public interface ServicioCarrera {

	public boolean insertarCarrera(Carrera c);
	public List<Carrera> listarCarreras();
	public boolean eliminarCarrera(Carrera c);
	public boolean actualizarCarrera(Carrera c);
	public List<Carrera> getCarrerasConEstudiantes();
	public List<Estudiante> getEstudiantesPorCiudad(String nombreCarrera, String ciudad);

}
