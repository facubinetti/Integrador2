package Controller;


import Factory.FactoryEntityManager;
import Servicios.*;

public class Controller {

	private ServicioCarrera sc;
	private ServicioEstudiante se;
	
	
	public Controller() {
		FactoryEntityManager factoryEntity = new FactoryEntityManager();
		this.sc = new ServicioCarreraImpl(factoryEntity);
		this.se = new ServicioEstudianteImpl(factoryEntity);
	};
	
	
}
