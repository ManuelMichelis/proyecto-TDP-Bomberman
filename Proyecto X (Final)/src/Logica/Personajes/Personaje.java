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
	 * Crea un personaje, d�ndole una celda de ubicaci�n. 
	 * @param c: celda de ubicaci�n.
	 */
	public Personaje (Celda c) {
		miUbicacion = c;
		modoDios=false;
	}
	
	
	// COMANDOS
	
	/**
	 * Solicita a la celda en la que se ubica poder moverse a la celda que se encuenta en la direcci�n "dir".
	 * @param dir: direcci�n a la que deseo moverme.
	 */
	public void mover(int dir) {
		miUbicacion.mover(this,dir);
		
	}
	
	/**
	 * Mata a un personaje.
	 */
	public abstract void morir();
	
	/**
	 * Actualiza la posici�n del personaje.
	 * @param nuevaUbicacion: nueva celda de ubicaci�n.
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
	 * Retorna TRUE si el personaje est� en modo dios, y FALSE en caso contrario.
	 * @return modoDios.
	 */
	public boolean tieneModoDios() {
		return modoDios;
	}
	
	/**
	 * Retorna la ubicaci�n del personaje.
	 * @return ubicaci�n del personaje.
	 */
	public Celda getUbicacion() {
		return miUbicacion;
	}
	
	/**
	 * Retorna el contenido gr�fico del personaje.
	 * @return contenido gr�fico del personaje.
	 */
	public GraficaPersonaje getGrafica(){
		return grafica;
	}
	
	/**
	 * Ejecuta el hilo del personaje
	 */
	public abstract void ejecutarHilo();
	
}