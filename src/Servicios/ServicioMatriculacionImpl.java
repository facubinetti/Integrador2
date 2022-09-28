package Servicios;

import Factory.FactoryEntityManager;
import Model.Matriculacion;
import Repository.MatriculacionRepositoryImpl;

public class ServicioMatriculacionImpl implements ServicioMatriculacion{
	private MatriculacionRepositoryImpl mr;
	private FactoryEntityManager fem;
	
	
	public ServicioMatriculacionImpl(FactoryEntityManager fem) {
		this.fem = fem;
		this.mr = new MatriculacionRepositoryImpl(fem.getEntityManger());
	}

	@Override
	public boolean insertarMatriculacion(Matriculacion m) {
		return mr.saveMatriculacion(m);
	}

	@Override
	public boolean eliminarMatriculacion(int id) {
		return mr.deleteMatriculacion(id);
	}

	@Override
	public boolean actualizarMatriculacion(Matriculacion m) {
		return mr.actualizarMatriculacion(m);
	}

}
