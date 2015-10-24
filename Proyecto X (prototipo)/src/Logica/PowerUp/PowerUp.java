package Logica.PowerUp;

import Grafica.GraficaPowerUp;
import Logica.Personajes.Bomberman;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public abstract class PowerUp {
	
	// ATRIBUTOS
	
	protected static int valor;
	protected GraficaPowerUp grafica;
	
	
	// COMANDOS
	
	/**
	 * Afecta a bomberman en forma gr�fica.
	 * @param b: bomberman a afectar.
	 */
	public void afectar(Bomberman b){
		grafica.afectar();
	}
	
	/**
	 * Retorna el contenido gr�fico del PowerUp.
	 * @return contenido gr�fico del PowerUp.
	 */
	public GraficaPowerUp getGrafica(){
		return grafica;
	}
	
}
