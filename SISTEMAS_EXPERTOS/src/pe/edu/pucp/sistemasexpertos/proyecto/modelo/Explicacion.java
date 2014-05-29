package pe.edu.pucp.sistemasexpertos.proyecto.modelo;

public class Explicacion {

	private int id;
	private String descripcion;
	private Double probabilidad;
	
	public Explicacion(int id, String descripcion, Double probabilidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.probabilidad = probabilidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(Double probabilidad) {
		this.probabilidad = probabilidad;
	}

	@Override
	public String toString() {
		return "Explicacion [id=" + id + ", descripcion=" + descripcion
				+ ", probabilidad=" + probabilidad + "]";
	}
	
}
