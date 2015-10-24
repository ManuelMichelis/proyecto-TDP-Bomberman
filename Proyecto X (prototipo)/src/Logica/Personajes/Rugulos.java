package Logica.Personajes;

import Grafica.GraficaRugulos;
import Logica.Celdas.Celda;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Rugulos extends Enemigo {
	
	// CONSTRUCTOR
	
	/**
	 * Crea un Rugulos d�ndole su celda de ubicaci�n y su bomberman enemigo.
	 * @param c: celda de ubicaci�n.
	 * @param b: bomberman enemigo.
	 */
	public Rugulos(Celda c, Bomberman b) {
		super(c,b);
		velocidad = 2;
		modoDios = false;
		grafica=new GraficaRugulos(c.getX()	, c.getY());
		hilo=new RugulosThread(this);
		
	}
	
	
	// COMANDOS
	
	/**
	 * Inicia el hilo de ejecuci�n de este enemigo.
	 */
	public void ejecutarHilo(){
		hilo.start();
	}
	
}
