package pe.edu.pucp.sistemasexpertos.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import jess.Fact;
import jess.JessException;

public class Explicacion extends Nodo {

	private static List<Explicacion> explicacionesRecurridas = new ArrayList<>();
	private static int[] explicacionesConcluyentes = new int[] { 10, 9, 6, 5 };
		
	private Double probabilidad;
	private List<Nodo> nodosQueExplica;
	private boolean esFinal; //Verdadero si es un nodo final o una explicación concluyente o no tiene hijos en la red o es una hoja del árbol
	
	public Explicacion(int id, String descripcion, Double probabilidad, Fact nodoPadre) {
		
		super(id, descripcion);
		
		boolean encontrado = false;
		
		for (Explicacion explicacion : explicacionesRecurridas) {
			if (explicacion.getId() == id) {
				encontrado = true;
				//No se vuelve a crear otra instancia o explicacion
				//sino se aumenta la probabilidad o confianza de la que
				//se habia creado anteriormente
				//Dicho de otra forma, este nodo servirá para explicar tanto
				//esta nueva actitud observada como la anterior por la que
				//se originó
				Double nuevaProbabilidad = explicacion.getProbabilidad();
				nuevaProbabilidad += probabilidad;	
				explicacion.setProbabilidad(nuevaProbabilidad);				

				//Esa instancia también sirve para explicar esta actitud
				try {
					explicacion.nodosQueExplica.add((Nodo) nodoPadre.getSlotValue("OBJECT").javaObjectValue(null));
				} catch (JessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//La instancia a devolver es un duplicado de la misma explicación
				setId(explicacion.getId());
				setDescripcion(explicacion.getDescripcion());
				this.probabilidad = explicacion.getProbabilidad();
				this.esFinal = explicacion.isEsFinal();
				this.nodosQueExplica = explicacion.nodosQueExplica;
				
			}
		}
		
		if (!encontrado) {
			//Esta actitud solo se puede explicar por otra razon que aun
			//no se encuentra entre nuestras explicaciones, por lo que
			//se agrega al vector
			setId(id);
			setDescripcion(descripcion);
			this.probabilidad = probabilidad;
			
			this.esFinal = false;
			for(int explicacionConcluyente : explicacionesConcluyentes) {
				if (explicacionConcluyente == id) {
					this.esFinal = true;
				}
			}
			
			this.nodosQueExplica = new ArrayList<>();
			try {
				this.nodosQueExplica.add((Nodo) nodoPadre.getSlotValue("OBJECT").javaObjectValue(null));
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			explicacionesRecurridas.add(this);
		}
	}

	public Double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(Double probabilidad) {
		this.probabilidad = probabilidad;
	}	
		
	public boolean isEsFinal() {
		return esFinal;
	}

	public void setEsFinal(boolean esFinal) {
		this.esFinal = esFinal;
	}

	public List<Nodo> getNodosQueExplica() {
		return nodosQueExplica;
	}

	public void setNodosQueExplica(List<Nodo> nodosQueExplica) {
		this.nodosQueExplica = nodosQueExplica;
	}

	@Override
	public String toString() {
		return "Explicacion [getId()=" + getId() + ", getDescripcion()="
				+ getDescripcion() + ", probabilidad=" + probabilidad
				+ ", esFinal=" + esFinal + "]";
	}
	
}
