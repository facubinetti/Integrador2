package Servicios;

import java.util.List;

import Model.Carrera;

public interface ServicioCarrera {

	public boolean insertarCarrera(Carrera c);
	public List<Carrera> listarCarreras();
	public boolean eliminarCarrera(Carrera c);
	public boolean actualizarCarrera(Carrera c);
	public List<Carrera> getCarrerasConEstudiantes();

}
