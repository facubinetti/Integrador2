package Servicios;

import java.util.ArrayList;
import java.util.List;

import Comparator.ComparadorDTO;
import DTO.CarreraDTO;
import Factory.FactoryEntityManager;
import Model.Carrera;
import Model.Matriculacion;
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
	public boolean eliminarCarrera(int id) {
		return cr.deleteCarrera(id);
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
	
	public  List<CarreraDTO> getReporteCarreras() {
		List<Carrera> carreras = cr.getCarrerasConEstudiantes();
		List<CarreraDTO> reporte = new ArrayList<>();
		
		int cantTotal = 0;
		
		for(Carrera c: carreras){
			List<Matriculacion> matriculaciones = c.getMatriculaciones();
			List<CarreraDTO> temporal = new ArrayList<>();
			for(Matriculacion m: matriculaciones) {
				int añoInscripcion = m.getInscripcion();
				int añoEgresado = m.getAnioGraduado();
				boolean sumoInscripto = false;
				boolean sumoEgresado = false;
				for(CarreraDTO cdto: temporal) {
					if(sumoInscripto==false && añoInscripcion==cdto.getAnio()) {
						cdto.sumarInscripto();
						cantTotal++;
						sumoInscripto=true;
					}
					if(sumoEgresado==false &&añoEgresado==cdto.getAnio()) {
						cdto.sumarEgresado();
						cantTotal++;
						sumoEgresado=true;
					}
				}
				if(sumoInscripto==false) {
					if(m.getAnioGraduado()!=0 && sumoEgresado==false) {
						CarreraDTO nuevo = new CarreraDTO(c.getId_carrera(),c.getNombre(),0,1,m.getAnioGraduado());
						CarreraDTO nuevo2 = new CarreraDTO(c.getId_carrera(),c.getNombre(),1,0,m.getInscripcion());
						cantTotal++;
						cantTotal++;
						temporal.add(nuevo);
						temporal.add(nuevo2);
					} else {
						CarreraDTO nuevo = new CarreraDTO(c.getId_carrera(),c.getNombre(),1,0,m.getInscripcion());
						cantTotal++;
						temporal.add(nuevo);
					}
				}
			}
			// ordenar temporal por año
			temporal.sort(new ComparadorDTO());
			reporte.addAll(temporal);
	}
		System.out.println(cantTotal);
		return reporte;
	}
}



