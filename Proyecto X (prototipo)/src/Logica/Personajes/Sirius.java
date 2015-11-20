package Logica.Personajes;

import Grafica.GraficaSirius;
import Logica.Celdas.Celda;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Sirius extends Enemigo {
	
	// ATRIBUTOS
	
	/**
	 * @param c
	 * @param b
	 */
	public Sirius(Celda c, Bomberman b) {
		super(c,b);
		velocidad = 4;
		modoDios = false;
		grafica = new GraficaSirius(c.getX(),c.getY());
		hilo=new SiriusThread(this);
	}
	
	/**
	 * Permite a Sirius pensar adonde moverse para alcanzar a bomberman y matarlo.
	 * @return dirección a la cual le es conveniente moverse para alcanzar a bomberman.
	 */
	public int pensar() {
		Celda destino = miEnemigo.getUbicacion();
		int xDestino = destino.getX();
		int yDestino = destino.getY();
		int dx = Math.abs(xDestino - miUbicacion.getX());
		int dy = Math.abs(yDestino - miUbicacion.getY());
		int dir = 1;
		
		if (dx < dy) {
			if (xDestino < miUbicacion.getX())
				dir = 4;
			else dir = 3;
		}
		else if (dx > dy) {
				 if (yDestino < miUbicacion.getY())
					 dir = 1;
				 else dir = 2;
			 }
			
			else {
					boolean abajoIzquierda = yDestino < miUbicacion.getY() && xDestino > miUbicacion.getX();
					boolean abajoDerecha = yDestino < miUbicacion.getY() && xDestino < miUbicacion.getX();
					boolean arribaIzquierda = yDestino > miUbicacion.getY() && xDestino > miUbicacion.getX();
					if (abajoIzquierda) {
						dir = 2;
					}
					else if (abajoDerecha) {
							dir = 4;
						 }
					else if (arribaIzquierda) {
							dir = 3;
					}
					else {
							dir = 1;
						 }
				}
		return dir;
	}
	
	public int pensar2() {
		
		Celda destino = miEnemigo.getUbicacion();
		int xDestino = destino.getX();
		int yDestino = destino.getY();
		int dx = Math.abs(xDestino - miUbicacion.getX());
		int dy = Math.abs(yDestino - miUbicacion.getY());
		int dir = 1;
		
		boolean abajoIzquierda = yDestino < miUbicacion.getY() && xDestino > miUbicacion.getX();
		boolean abajoDerecha = yDestino < miUbicacion.getY() && xDestino < miUbicacion.getX();
		boolean arribaIzquierda = yDestino > miUbicacion.getY() && xDestino > miUbicacion.getX();
		
		if (abajoIzquierda) {
			// elijo entre izquierda y abajo
		}
		else if (abajoDerecha) {
				// elijo entre abajo y derecha
			 }
			 else if (arribaIzquierda) {
				// elijo entre arriba e izquierda
			 	  }
			 	  else {
			 		  	 // elijo entre arriba y derecha
			 	  	   }
	
		return dir;
	}
		
}
