package Logica.PowerUp;

import Grafica.GraficaBombality;
import Logica.Personajes.Bomberman;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Bombality extends PowerUp {
	
	// CONSTRUCTOR
	
	/**
	 * Crea un PowerUp de tipo Bombality, inicializando el valor en puntaje que posee y su contenido gráfico.
	 */
	public Bombality() {
		valor = 35;
		grafica=new GraficaBombality();
	}
	
	
	// COMANDOS
	
	/**
	 * Incrementa la cantidad de bombas que bomberman puede colocar simultaneamente e incrementa su puntaje en "valor" puntos..
	 */
	public void afectar(Bomberman b) {
		super.afectar(b);
		b.sumarPuntos(valor);
		b.sumarCantBombasSimult();
		
		
	}

}
