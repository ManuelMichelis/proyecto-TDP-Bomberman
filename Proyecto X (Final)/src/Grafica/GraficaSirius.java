package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class GraficaSirius extends GraficaPersonaje {

	/**
	 * Constructor de GraficaRugulos: crea la etiqueta grafica del Rugulos e inicializa todos sus sprites
	 * @param coordenada x del rugulos
	 * @param coordenada y del rugulos
	 */
	public GraficaSirius(int x, int y) {
		super(x,y);
		//Inicializo los sprites
		sprites[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Negro/Quemado.gif"));
		sprites[1] = new ImageIcon(this.getClass().getResource("/Imagenes/Negro/Atras.gif"));
		sprites[2] = new ImageIcon(this.getClass().getResource("/Imagenes/Negro/Adelante.gif"));
		sprites[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Negro/Derecha.gif"));
		sprites[3] = new ImageIcon(this.getClass().getResource("/Imagenes/Negro/Izquierda.gif"));
		sprites[5] = new ImageIcon(this.getClass().getResource("/Imagenes/Negro/Quieto.gif"));
		//Seteo la grafica del rugulos quieto por defecto
		grafico=new JLabel(sprites[5]);
	}
	
}
