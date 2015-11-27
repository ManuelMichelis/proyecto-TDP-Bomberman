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
	private Bomberman miDue�o;
	private Thread hilo;
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea una bomba, d�ndole un arreglo de celdas, que son aquellas a las que puede alcanzar la explosi�n de dicha bomba, y su due�o, bomberman.
	 * @param A: arreglo de celdas dentro del alcance de la explosi�n de la bomba.
	 * @param bomber: bomberman due�o de la bomba.
	 */
	public Bomba(Celda [] A, Bomberman bomber) {
		miAlcance = A;
		miDue�o=bomber;
		miUbicacion=bomber.getUbicacion();
		miUbicacion.setBomba(this);
		hilo = new BombaThread(this);
		
		}
	
	
	// COMANDOS
	
	/**
	 * Ejecuta el hilo de la bomba, comenzando con el proceso de explosi�n.
	 */
	public void explotar() {
		hilo.start();
	}
	
	
	// CONSULTAS
	
	/**
	 * Retorna el bomberman que es due�o de la bomba.
	 * @return bomberman due�o de la bomba.
	 */
	public Bomberman getDue�o(){
		return miDue�o;
	}
	
	/**
	 * Retorna el alcance de explosi�n de la bomba.
	 * @return arreglo de celdas que est�n dentro del alcance de explosi�n.
	 */
	public Celda[] getAlcance(){
		return miAlcance;
	}
	
	/**
	 * Retorna la ubicaci�n de la bomba.
	 * @return celda de ubicaci�n de la bomba.
	 */
	public Celda getUbicacion(){
		return miUbicacion;
	}
		
}
