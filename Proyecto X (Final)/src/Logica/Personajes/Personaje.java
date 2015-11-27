package Logica.Personajes;
import Logica.Celdas.Celda;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public abstract class Personaje {
	
	
	// ATRIBUTOS
	
	protected Celda miUbicacion;
	protected int velocidad;
	protected boolean modoDios;
	protected GraficaPersonaje grafica;
	
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un personaje, dándole una celda de ubicación. 
	 * @param c: celda de ubicación.
	 */
	public Personaje (Celda c) {
		miUbicacion = c;
		modoDios=false;
	}
	
	
	// COMANDOS
	
	/**
	 * Solicita a la celda en la que se ubica poder moverse a la celda que se encuenta en la dirección "dir".
	 * @param dir: dirección a la que deseo moverme.
	 */
	public void mover(int dir) {
		miUbicacion.mover(this,dir);
		
	}
	
	/**
	 * Mata a un personaje.
	 */
	public abstract void morir();
	
	/**
	 * Actualiza la posición del personaje.
	 * @param nuevaUbicacion: nueva celda de ubicación.
	 */
	public abstract void cambiarPosicion(Celda nuevaUbicacion) ;
	
	
	// CONSULTAS
	
	/**
	 * Retorna el valor de la velocidad del personaje.
	 * @return  valor de velocidad del personaje.
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Retorna TRUE si el personaje está en modo dios, y FALSE en caso contrario.
	 * @return modoDios.
	 */
	public boolean tieneModoDios() {
		return modoDios;
	}
	
	/**
	 * Retorna la ubicación del personaje.
	 * @return ubicación del personaje.
	 */
	public Celda getUbicacion() {
		return miUbicacion;
	}
	
	/**
	 * Retorna el contenido gráfico del personaje.
	 * @return contenido gráfico del personaje.
	 */
	public GraficaPersonaje getGrafica(){
		return grafica;
	}
	
	/**
	 * Ejecuta el hilo del personaje
	 */
	public abstract void ejecutarHilo();
	
}