package Logica.PowerUp;

import Grafica.GraficaFatality;
import Logica.Personajes.Bomberman;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Fatality extends PowerUp {

	
	// CONSTRUCTOR
	
	/**
	 * Crea un PowerUp de tipo Fatality, inicializando el valor en puntaje que posee y su contenido gráfico.
	 */
	public Fatality() {
		valor = 35;
		grafica=new GraficaFatality();
	}
	
	/**
	 * Duplica el poder de explosión de las bombas que coloca bomberman  incrementa su puntaje en "valor" puntos.
	 */
	public void afectar(Bomberman b) {
		super.afectar(b);
		b.sumarPuntos(valor);
		b.duplicarPoderDeExp();
	}



	




}
