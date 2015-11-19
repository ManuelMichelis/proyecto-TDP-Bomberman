package Logica.Personajes;

import Logica.Bomba;
import Logica.Celdas.Celda;
import Logica.PowerUp.PowerUp;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian:
 */
public class Bomberman extends Personaje {
	
	// ATRIBUTOS
	
	private int puntaje;
	private boolean muerto;
	private int cantBombasSimult;
	private int poderDeExplosion;
	private int direccion=0;
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un bomberman dándole su celda de ubicación.
	 * @param c: celda de ubicación.
	 */
	public Bomberman(Celda c) {
		super(c);
		muerto=false;
		velocidad = 4;
		cantBombasSimult = poderDeExplosion = 1;
		grafica=new GraficaBomberman(c.getX(),c.getY());
		hilo=new BombermanThread(this);
	}
	
	
	// COMANDOS
	
	/**
	 * Duplica el poder de explosión de bomberman.
	 */
	public void duplicarPoderDeExp() {
		poderDeExplosion *= 2;
	}
	
	/**
	 * Incrementa en 1 la cantidad de bombas que pueden ser colocadas simultaneamente.
	 */
	public void sumarCantBombasSimult() {
		cantBombasSimult++;
		System.out.println("Ahora bomberman podra poner "+cantBombasSimult+" bombas simultaneas.");
	}
	
	/**
	 * Incrementa en "p" puntos el puntaje de bomberman.
	 * @param p: puntaje a sumar.
	 */
	public void sumarPuntos(int p) {
		puntaje += p;
	}
	
	/**
	 * Duplica la velocidad de bomberman.
	 */
	public void duplicarVelocidad () {
		velocidad *= 2;
	}
	
	/**
	 * Activa/Desactiva el modo dios de bomberman.
	 * @param b: valor de modo dios.
	 */
	public void setModoDios(boolean b) {
		modoDios = b;
	}
	
	public GraficaPersonaje getGrafica(){
		return grafica;
	}
	
	/**
	 * Coloca una bomba en la celda de ubicación.
	 */
	public void ponerBomba() {
		if(cantBombasSimult>0){
			Bomba bombita=new Bomba(miUbicacion.sectorEnPeligro(poderDeExplosion),this);
			bombita.explotar();
			if(!modoDios)
				cantBombasSimult--;
		}
	}
	
	public void morir () {
		muerto=true;
		grafica.destruir();
		// termina el juego
	}
	
	/**
	 * Retorna TRUE si bomberman está muerto o FALSE.
	 * @return
	 */
	public boolean estaMuerto(){
		return muerto;
	}
	
	/**
	 * Captura un powerUp.
	 * @param p: PowerUp a capturar.
	 */
	public void capturarPowerUp(PowerUp p){
		p.afectar(this);
	}
	
	public void cambiarPosicion(Celda nuevaUbicacion){
		miUbicacion.setBomberman(null);
		miUbicacion=nuevaUbicacion;
		miUbicacion.setBomberman(this);
	}
	
	// CONSULTAS
	
	/**
	 * Retorna el puntaje de bomberman.
	 * @return puntaje de bomberman.
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Retorna la cantidad actual de bombas que puede colocar simultaneamente bomberman.
	 * @return cantidad de bombas que se pueden colocar en simultáneo.
	 */
	public int getCantBombasSimult() {
		return cantBombasSimult;
	}
	
	/**
	 * Retorna el poder de explosión de las bombas que coloca bomberman.
	 * @return poder de explosión de las bombas.
	 */
	public int getPoderDeExp() {
		return poderDeExplosion;
	}
	
	/**
	 * Asigna la dirección a la cual se moverá bomberman.
	 */
	public void mover(int dir){
		direccion=dir;
	}
	
	/**
	 * Retorna la dirección en la cual se mueve bomberman.
	 * @return dirección de movimiento.
	 */
	public int getDireccion(){
		return direccion;
	}
	
	/**
	 * Modeifica la dirección en la cual se mueve bomberman.
	 * @param dir: dirección en la cual se mueve bomberman.
	 */
	public void setDireccion(int dir){
		direccion=dir;
	}
	
}