package pe.edu.pucp.sistemasexpertos.proyecto.modelo;

public class Actitud {
	public int id;
	public String descripcion;	
	
	public Actitud(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Actitud(int id) {
		this.id = id;
		this.descripcion = "LLENAR SEGÚN LA BASE DE DATOS";
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
	
	@Override
	public String toString() {
		return "Actitud [id=" + id + ", descripcion=" + descripcion + "]";
	}
}
