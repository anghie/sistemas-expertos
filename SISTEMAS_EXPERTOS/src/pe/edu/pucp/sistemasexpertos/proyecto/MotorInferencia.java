package pe.edu.pucp.sistemasexpertos.proyecto;
import jess.*;

import java.util.Iterator;
import java.util.List;

import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Actitud;
import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Explicacion;

public class MotorInferencia {
    private Rete motor;
    private WorkingMemoryMarker marcador;

    public MotorInferencia(List<Actitud> baseDeDatos) throws JessException {
    	motor = new Rete();
    	motor.reset();

    	motor.batch("reglas.clp");
    	
    	for (Actitud actitud : baseDeDatos) {
    		motor.add(actitud);
    	}

        marcador = motor.mark();
    }
    
    @SuppressWarnings("unchecked")
	public Iterator<Explicacion> ejecutar() throws JessException {
    	
    	motor.add(new Actitud(9000, "Julieta no desea salir en citas con Romeo como lo hacian usualmente"));
    	
    	motor.resetToMark(marcador);
    	
    	motor.run();
        
        return motor.getObjects(new Filter.ByClass(Explicacion.class));
    }
    
}

