package pe.edu.pucp.sistemasexpertos.proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jess.Fact;
import jess.JessException;
import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Explicacion;
import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Nodo;

public class Principal {

	public static void main(String[] args) {
		try {
						
			List<Nodo> baseDeDatos = new ArrayList<>();
			
			baseDeDatos.add(new Nodo(9000,
					"Julieta no desea salir en citas con Romeo como lo hacian usualmente")); //UNA ACTITUD
//			baseDeDatos.add(new Nodo(1000,
//					"Julieta actua inusualmente fastidiada con Romeo cuando se reune con el")); //OTRA ACTITUD
//			baseDeDatos.add(new Nodo(8000,
//					"Julieta empieza a olvidar aniversarios y fechas especiales en la relacion")); //OTRA ACTITUD
			//baseDeDatos.add(new Actitud(800)); //ACTITUD FUERA DE LA BASE DE DATOS
			
			System.out.println("***INGRESO DE DATOS***");
			System.out.println("Usted ingreso estos indicios:");
			
			for (Nodo actitud : baseDeDatos) {
				System.out.println(actitud);
			}
			
			System.out.println("Total = " + baseDeDatos.size() + " actitud(es)");
			
			MotorInferencia motor = new MotorInferencia(baseDeDatos);	
			procesarPregunta(motor);
			
		} catch (JessException e) {
			e.printStackTrace();
		}

	}

	private static void procesarPregunta(MotorInferencia motor) throws JessException {
		Iterator<Explicacion> explicaciones = motor.ejecutar();
		
		System.out.println("***RESULTADOS***");
		System.out.println("El sistema le brinda la(s) siguiente(s) explicacion(es) o inferencia(s) intermedia(s):");
				
		int explicacionesNo = 0;
		while (explicaciones.hasNext()) {
			Explicacion explicacion = explicaciones.next();
			System.out.println(explicacion);
//			System.out.println("\tActitudes que explica:");
//			for(Actitud actitud : explicacion.getActitudesQueExplica()) {
//				System.out.println("\t" + actitud);
//			}
			explicacionesNo++;
		}
		
		System.out.println("Total = " + explicacionesNo + " evento(s) observado(s)");
	}

}
