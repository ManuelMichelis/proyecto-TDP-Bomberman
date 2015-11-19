package Logica.Personajes;
import Grafica.GraficaAltair;
import Logica.Celdas.Celda;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Altair extends Enemigo {
	
	public Altair(Celda c, Bomberman b) {
		super(c,b);
		velocidad = 2;
		modoDios = true;
		grafica = new GraficaAltair(c.getX(),c.getY());
		hilo=new AltairThread(this);
	}
	
	


}
