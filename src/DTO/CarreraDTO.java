package DTO;

public class CarreraDTO{

	private int idCarrera;
	private String nombreCarrera;
	private long cantInscriptos;
	private long cantEgresados;
	private Long anioInscripcion;
	
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
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public long getCantInscriptos() {
		return cantInscriptos;
	}
	public void setCantInscriptos(int cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}
	public long getCantEgresados() {
		return cantEgresados;
	}
	public void setCantEgresados(int cantEgresados) {
		this.cantEgresados = cantEgresados;
	}

	public long getInscripcion() {
		return anioInscripcion;
	}

	public void setInscripcion(Long inscripcion) {
		this.anioInscripcion = inscripcion;
	}

	@Override
	public String toString() {
		return "CarreraDTO [idCarrera=" + idCarrera + ", nombreCarrera=" + nombreCarrera + ", cantInscriptos="
				+ cantInscriptos + ", cantEgresados=" + cantEgresados + ", anioInscripcion=" + anioInscripcion + "]";
	}
	
}
