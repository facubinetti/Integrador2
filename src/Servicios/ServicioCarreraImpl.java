package Servicios;

import java.util.List;


import Factory.FactoryEntityManager;
import Model.Carrera;
import Repository.CarreraRepositoryImpl;

public class ServicioCarreraImpl implements ServicioCarrera{
	private CarreraRepositoryImpl cr;
	private FactoryEntityManager fem;
	
	public ServicioCarreraImpl(FactoryEntityManager fem) {
		this.fem = fem;
		this.cr = new CarreraRepositoryImpl(fem.getEntityManger());
	};
	
	

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
	
	public boolean actualizarCarrera(Carrera c) {
		return cr.actualizarCarrera(c);
	}

	@Override
	public List<Carrera> getCarrerasConEstudiantes() {
		return cr.getCarrerasConEstudiantes();
	}



	@Override
	public Carrera getCarrera(int id) {
		return cr.getCarrera(id);
	}

}
