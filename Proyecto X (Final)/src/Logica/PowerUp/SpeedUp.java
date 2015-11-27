package Logica.PowerUp;

import Grafica.GraficaSpeedUp;
import Logica.Personajes.Bomberman;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class SpeedUp extends PowerUp {

	
	// CONSTRUCTOR
	
	/**
	 * Crea un PowerUp de tipo SpeedUp, inicializando el valor en puntaje que posee y su contenido gráfico.
	 */
	public SpeedUp() {
		valor = 30;
		grafica=new GraficaSpeedUp();
	}
	
	
	// COMANDOS
	
	/**
	 * Afecta a bomberman, duplicando su velocidad e incrementando su puntaje en "valor" puntos.
	 */
	public void afectar(Bomberman b) {
		super.afectar(b);
		b.sumarPuntos(valor);
		b.duplicarVelocidad();
	}




}
