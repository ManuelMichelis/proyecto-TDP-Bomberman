package Logica.PowerUp;

import Grafica.GraficaMasacrality;
import Logica.Personajes.Bomberman;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Masacrality extends PowerUp {

	/**
	 * Crea un PowerUp de tipo Masacrality, inicializando el valor en puntaje que posee y su contenido gráfico.
	 */
	public Masacrality(){
		valor=50;
		grafica=new GraficaMasacrality();
	}
	
	/**
	 * Afecta a bomberman, dándole el modo dios e incrementando su puntaje en "valor" puntos.
	 */
	public void afectar(Bomberman b) {
		super.afectar(b);
		//b.setModoDios(true);
		//FALTA IMPLEMENTAR
		//b.setModoDios(false);
	}


	

}
