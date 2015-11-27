package Logica.Personajes;

import Logica.Celdas.Celda;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public abstract class Enemigo extends Personaje {
	
	
	// ATRIBUTOS
	
	protected Bomberman miEnemigo;
	protected static int valor;
	protected EnemigosThread hilo;
	
	// CONSTRUCTOR
	
	/**
	 * Crea un enemigo dándole una celda de ubicación y un bomberman enemigo.
	 * @param c: celda de ubicación.
	 * @param b: bomberman enemigo.
	 */
	public Enemigo(Celda c, Bomberman b) {
		super(c);
		miEnemigo = b;
	}
	
	
	// COMANDOS	
	
	public void morir() {
		miEnemigo.sumarPuntos(valor);
		grafica.destruir();
		hilo.destruir();
		}
	
	
	public void cambiarPosicion(Celda nuevaUbicacion){
		miUbicacion.quitarEnemigo(this);
		miUbicacion=nuevaUbicacion;
		miUbicacion.recibirEnemigo(this);
	}
	
	// CONSULTAS
	
	/**
	 * Retorna el bomberman enemigo.
	 * @return bomberman enemigo.
	 */
	public Bomberman getEnemigo(){
		return miEnemigo;
	}
	
	/**
	 * Retorna el valor en puntaje de este enemigo.
	 * @return valor en puntaje del enemigo.
	 */
	public int getValor() {
		return valor;
	}	
	
	public void ejecutarHilo(){
		hilo.start();
	}
	
	public void cortarHilo(){
		hilo.destruir();
	}

}
