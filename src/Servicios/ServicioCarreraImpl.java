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
	
	//Facu
//	@Override
//	public  List<CarreraDTO> getReporteCarreras() {
//		List<CarreraDTO> tmpInscriptos = cr.getReporteCarrerasInscriptos();
//		List<CarreraDTO> tmpEgresados = cr.getReporteCarrerasEgresados();
//		List<CarreraDTO> salida = new ArrayList<CarreraDTO>();
//		int idEgresado = tmpInscriptos.get(0).getIdCarrera();
//		int idInscripto = 0;
//		boolean anionoexiste;
//		CarreraDTO dto;
//
//		        for(int i=0; i< tmpInscriptos.size(); i++) { 
//		            idInscripto=tmpInscriptos.get(i).getIdCarrera();
//		            anionoexiste = false;
//		                for(int j=0; j< tmpEgresados.size(); j++) { 
//		                    idEgresado = tmpEgresados.get(j).getIdCarrera();
//		                    if(tmpInscriptos.get(i).getAnio()== tmpEgresados.get(j).getAnio() && idInscripto == idEgresado) {
//		                        dto = tmpEgresados.get(j);
//		                        dto.setCantInscriptos(tmpInscriptos.get(i).getCantInscriptos());
//		                        salida.add(dto);
//		                        break;
//		                    }else if(idInscripto != idEgresado){
//		                        anionoexiste = true;
//		                        break;
//		                    }
//		                }
//		            if(anionoexiste){
//		                dto = tmpInscriptos.get(i);
//		                salida.add(dto);
//		            }
//		        }
//  
//		        return salida;
//	}
	
	//Tomi
//	public  List<CarreraDTO> getReporteCarreras() {
//
//		List<CarreraDTO> tmpInscriptos = cr.getReporteCarrerasInscriptos();
//		List<CarreraDTO> tmpEgresados = cr.getReporteCarrerasEgresados();
//		List<CarreraDTO> salida = new ArrayList<CarreraDTO>();
//
//		 CarreraDTO dto;
//	        for(int i=0; i< tmpInscriptos.size(); i++) { 
//	                for(int j=0; j< tmpEgresados.size(); j++) {
//
//	                    if(tmpInscriptos.get(i).getIdCarrera() == tmpEgresados.get(j).getIdCarrera() && tmpInscriptos.get(i).getAnio() == tmpEgresados.get(j).getAnio()) {
//			                //suma los 2, los agrega y elimina el egresados
//			                dto = tmpEgresados.get(j);
//			                tmpEgresados.remove(dto);
//			                dto.setCantInscriptos(tmpInscriptos.get(i).getCantInscriptos());
//			                salida.add(dto);
//			                break;
//			            }else if(tmpInscriptos.get(i).getIdCarrera() > tmpEgresados.get(j).getIdCarrera() || tmpInscriptos.get(i).getAnio() > tmpEgresados.get(j).getAnio()) {
//			                //suma el egresados menor, lo agrega y lo borra
//			                dto = tmpEgresados.get(j);
//			                tmpEgresados.remove(dto);
//			                salida.add(dto);
//			                
//			            }else if(tmpInscriptos.get(i).getIdCarrera() < tmpEgresados.get(j).getIdCarrera() || tmpInscriptos.get(i).getAnio() < tmpEgresados.get(j).getAnio()) {
//			                break;
//		
//			             }
//	                    
//	                }
//			        if(tmpEgresados.size() == 0){
//			            dto = tmpInscriptos.get(i);
//			            salida.add(dto);
//			        }
//	        }
//
//	        return salida;
//		}
	
	// prueba  ------------------------------------------------------------------
	@Override
	public  List<CarreraDTO> getReporteCarrerasInscriptos() {
		List<CarreraDTO> tmpInscriptos = cr.getReporteCarrerasInscriptos();
		return tmpInscriptos;
	}
	@Override
	public  List<CarreraDTO> getReporteCarrerasEgresados() {
		List<CarreraDTO> tmpInscriptos = cr.getReporteCarrerasEgresados();
		return tmpInscriptos;
	}
	// -------------------------------------------------------------------------------------

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
						CarreraDTO nuevo = new CarreraDTO(c.getNombre(),c.getId_carrera(),0,1,m.getAnioGraduado());
						CarreraDTO nuevo2 = new CarreraDTO(c.getNombre(),c.getId_carrera(),1,0,m.getInscripcion());
						cantTotal++;
						cantTotal++;
						temporal.add(nuevo);
						temporal.add(nuevo2);
					} else {
						CarreraDTO nuevo = new CarreraDTO(c.getNombre(),c.getId_carrera(),1,0,m.getInscripcion());
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



