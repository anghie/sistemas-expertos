package pe.edu.pucp.sistemasexpertos.proyecto.modelo;


public class Actitud extends Nodo {
	
	public Actitud(int id, String descripcion) {
		super(id, descripcion);
	}

	@Override
	public String toString() {
		return "Actitud [getId()=" + getId() + ", getDescripcion()="
				+ getDescripcion() + "]";
	}
	
}
