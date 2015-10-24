package Grafica;

import javax.swing.*;
/**
 * Clase Rugulos Grafico 
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian 
 *
 */
public class GraficaRugulos extends GraficaPersonaje {
	/**
	 * Constructor de GraficaRugulos: crea la etiqueta grafica del Rugulos e inicializa todos sus sprites
	 * @param coordenada x del rugulos
	 * @param coordenada y del rugulos
	 */
	public GraficaRugulos(int x, int y) {
		super(x,y);
		//Inicializo los sprites
		sprites[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Azul/Quemado.gif"));
		sprites[1] = new ImageIcon(this.getClass().getResource("/Imagenes/Azul/Atras.gif"));
		sprites[2] = new ImageIcon(this.getClass().getResource("/Imagenes/Azul/Adelante.gif"));
		sprites[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Azul/Derecha.gif"));
		sprites[3] = new ImageIcon(this.getClass().getResource("/Imagenes/Azul/Izquierda.gif"));
		sprites[5] = new ImageIcon(this.getClass().getResource("/Imagenes/Azul/Quieto.gif"));
		//Seteo la grafica del rugulos quieto por defecto
		grafico=new JLabel(sprites[5]);
	}
	
	

}
