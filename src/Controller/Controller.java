package Controller;


import Factory.*;
import Servicios.*;
import Model.*;

public class Controller {

	private ServicioCarrera sc;
	private ServicioEstudiante se;
	
	
	public Controller() {
		FactoryEntityManager factoryEntity = new FactoryEntityManager();
		this.sc = new ServicioCarreraImpl(factoryEntity);
		this.se = new ServicioEstudianteImpl(factoryEntity);
	};
	
	
	public boolean altaEstudiante(Estudiante e, Carrera c) {
		Matriculacion m = new Matriculacion(e,c,false,0);
		e.agregarMatriculacion(m);
		c.agregarMatriculacion(m);
		if(this.sc.actualizarCarrera(c)&&this.se.insertarEstudiante(e))
			return true;
		return false;
	}
	
	
}
