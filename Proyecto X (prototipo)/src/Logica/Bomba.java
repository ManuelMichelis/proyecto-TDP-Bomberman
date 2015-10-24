package Logica;

import Logica.Celdas.Celda;
import Logica.Personajes.Bomberman;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Bomba {

	// ATRIBUTOS
	
	private Celda [] miAlcance;
	private Celda miUbicacion;
	private Bomberman miDueño;
	private Thread hilo;
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea una bomba, dándole un arreglo de celdas, que son aquellas a las que puede alcanzar la explosión de dicha bomba, y su dueño, bomberman.
	 * @param A: arreglo de celdas dentro del alcance de la explosión de la bomba.
	 * @param bomber: bomberman dueño de la bomba.
	 */
	public Bomba(Celda [] A, Bomberman bomber) {
		miAlcance = A;
		miDueño=bomber;
		miUbicacion=bomber.getUbicacion();
		miUbicacion.setBomba(this);
		hilo = new BombaThread(this);
		
		}
	
	
	// COMANDOS
	
	/**
	 * Ejecuta el hilo de la bomba, comenzando con el proceso de explosión.
	 */
	public void explotar() {
		hilo.start();
	}
	
	
	// CONSULTAS
	
	/**
	 * Retorna el bomberman que es dueño de la bomba.
	 * @return bomberman dueño de la bomba.
	 */
	public Bomberman getDueño(){
		return miDueño;
	}
	
	/**
	 * Retorna el alcance de explosión de la bomba.
	 * @return arreglo de celdas que están dentro del alcance de explosión.
	 */
	public Celda[] getAlcance(){
		return miAlcance;
	}
	
	/**
	 * Retorna la ubicación de la bomba.
	 * @return celda de ubicación de la bomba.
	 */
	public Celda getUbicacion(){
		return miUbicacion;
	}
		
}
