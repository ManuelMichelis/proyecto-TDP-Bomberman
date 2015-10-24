package Logica.Personajes;

import Grafica.GraficaPersonaje;
import Logica.Celdas.Celda;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Sirius extends Enemigo {
	
	// ATRIBUTOS
	
	/**
	 * 
	 * @param c
	 * @param b
	 */
	public Sirius(Celda c, Bomberman b) {
		super(c,b);
		velocidad = 3;
		modoDios = false;
	}
	
	/**
	 * Permite a Sirius pensar adonde moverse para alcanzar a bomberman y matarlo.
	 * @return dirección a la cual le es conveniente moverse para alcanzar a bomberman.
	 */
	public int pensar() {
		// Pendiente para la próxima entrega.
		return 0;
	}

	public GraficaPersonaje getGrafica() {
		// TODO Auto-generated method stub
		return null;
	}
}
