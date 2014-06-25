package pe.edu.pucp.sistemasexpertos.proyecto;
import jess.*;

import java.util.Iterator;
import java.util.List;

import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Actitud;
import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Explicacion;
import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Nodo;

public class MotorInferencia {
    private Rete motor;
    private WorkingMemoryMarker marcador;

    public MotorInferencia(List<Nodo> baseDeDatos) throws JessException {
    	motor = new Rete();
    	motor.reset();

    	motor.batch("reglas.clp");
    	
    	for (Nodo actitud : baseDeDatos) {
    		motor.add(actitud);
    	}

        marcador = motor.mark();
    }
    
    @SuppressWarnings("unchecked")
	public Iterator<Explicacion> ejecutar() throws JessException {
    	
//    	motor.resetToMark(marcador);
//    	
    	motor.run();
        
//        Iterator<Explicacion> explicaciones =
//        		motor.getObjects(new Filter.ByClass(Explicacion.class));
//        
//        while (explicaciones.hasNext()) {
//			Explicacion explicacion = explicaciones.next();
//			motor.add(explicacion);
//		}
//        
//        motor.run();
        
        return motor.getObjects(new Filter.ByClass(Explicacion.class));       
        
    }
    
}

