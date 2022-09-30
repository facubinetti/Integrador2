package DTO;

/**
 * 
 * @author Grupo1
 * @version Unique Version
 * @category DTO
 * 
 */

public class CarreraDTO{

	/**
	 * Identificador unico
	 */
	private int idCarrera;
	
	/**
	 * Nombre de la carrera
	 */
	private String nombreCarrera;
	
	/**
	 * Cantidad de Inscriptos en la carrera
	 */
	private long cantInscriptos;
	
	/**
	 * Cantidad de Egresados de la carrera
	 */
	private long cantEgresados;
	
	/**
	 * Anio de inscripcion de la carrera
	 */
	private Long anioInscripcion;
	
	
	/**
	 * Constructor
	 */
	public CarreraDTO() {
	}
		

	public CarreraDTO(int idCarrera, String nombreCarrera, long cantInscriptos, long cantEgresados, Long anioInscripcion) {
		super();
		this.idCarrera = idCarrera;
		this.nombreCarrera = nombreCarrera;
		this.cantInscriptos = cantInscriptos;
		this.cantEgresados = cantEgresados;
		this.anioInscripcion= anioInscripcion;
	}

	
	//getters y setters
	/**
	 * Obtener el id de la carrera
	 * @return idCarrera
	 */
	public int getIdCarrera() {
		return idCarrera;
	}
	
	/**
	 * Setear nuevo valor a idCarrera
	 * @param idCarrera nuevo id para la carrera
	 */
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	
	/**
	 * Obtener el nombre de la carrera
	 * @return nombreCarrera
	 */
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	
	/**
	 * Cambiar nombre de la carrera
	 * @param nombreCarrera nuevo nombre de la carrera
	 */
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	
	/**
	 * Obtener cantidad de inscriptos
	 * @return cantInscriptos 
	 */
	public long getCantInscriptos() {
		return cantInscriptos;
	}
	
	/**
	 * Cambiar la cantidad de inscriptos 
	 * @param cantInscriptos nueva cantidad de inscriptos
	 */
	public void setCantInscriptos(int cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}
	
	/**
	 * Obtener cantidad de egresados
	 * @return cantEgresados
	 */
	public long getCantEgresados() {
		return cantEgresados;
	}
	
	/**
	 * Cambiar la cantidad de egresados
	 * @param cantEgresados nueva cantidad de egresados
	 */
	public void setCantEgresados(int cantEgresados) {
		this.cantEgresados = cantEgresados;
	}

	/**
	 * Obtener el anio de inscripcion inscripcion
	 * @return anioInscripcion
	 */
	public long getInscripcion() {
		return anioInscripcion;
	}

	/**
	 * Cambiar el anio de inscripcion
	 * @param inscripcion nuevo da
	 */
	public void setInscripcion(Long inscripcion) {
		this.anioInscripcion = inscripcion;
	}

	/**
	 * Convierte el objeto a string
	 * @return stringCarrera
	 */
	@Override
	public String toString() {
		return "CarreraDTO [idCarrera=" + idCarrera + ", nombreCarrera=" + nombreCarrera + ", cantInscriptos="
				+ cantInscriptos + ", cantEgresados=" + cantEgresados + ", anioInscripcion=" + anioInscripcion + "]";
	}
	
}
