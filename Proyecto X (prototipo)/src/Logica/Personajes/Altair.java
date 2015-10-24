package Logica.Personajes;
import Grafica.GraficaPersonaje;
import Logica.Celdas.Celda;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Altair extends Enemigo {
	
	public Altair(Celda c, Bomberman b) {
		super(c,b);
		velocidad = 1;
	}
	
	
	public GraficaPersonaje getGrafica() {
		// TODO Auto-generated method stub
		return null;
	}


}
