package Logica.PowerUp;

import Grafica.GraficaFatality;
import Logica.Personajes.Bomberman;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Fatality extends PowerUp {

	
	// CONSTRUCTOR
	
	/**
	 * Crea un PowerUp de tipo Fatality, inicializando el valor en puntaje que posee y su contenido gr�fico.
	 */
	public Fatality() {
		valor = 35;
		grafica=new GraficaFatality();
	}
	
	/**
	 * Duplica el poder de explosi�n de las bombas que coloca bomberman  incrementa su puntaje en "valor" puntos.
	 */
	public void afectar(Bomberman b) {
		super.afectar(b);
		b.sumarPuntos(valor);
		b.duplicarPoderDeExp();
	}



	




}
