package pe.edu.pucp.sistemasexpertos.proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Actitud;
import pe.edu.pucp.sistemasexpertos.proyecto.modelo.Explicacion;
import jess.JessException;

public class Principal {

	public static void main(String[] args) {
		try {
						
			List<Actitud> baseDeDatos = new ArrayList<>();

			baseDeDatos.add(new Actitud(9000,
					"Julieta no desea salir en citas con Romeo como lo hacian usualmente")); //UNA ACTITUD
			baseDeDatos.add(new Actitud(1000,
					"Julieta actua inusualmente fastidiada con Romeo cuando se reune con el")); //OTRA ACTITUD
			baseDeDatos.add(new Actitud(8000,
					"Julieta empieza a olvidar aniversarios y fechas especiales en la relacion")); //OTRA ACTITUD
			//baseDeDatos.add(new Actitud(800)); //ACTITUD FUERA DE LA BASE DE DATOS
			
			System.out.println("***INGRESO DE DATOS***");
			System.out.println("Usted ingreso estos indicios:");
			
			for (Actitud actitud : baseDeDatos) {
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
			System.out.println(explicaciones.next());
			explicacionesNo++;
		}
		
		System.out.println("Total = " + explicacionesNo + " evento(s) observado(s)");
	}

}
