package Grafica;
import javax.swing.*;
/**
 * Clase Bomberman Grafico
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 */
public class GraficaBomberman extends GraficaPersonaje {
	/**
	 * Constructor Grafica Bomberman: inicializa los sprites del bomberman y su etiqueta grafica
	 * @param coordenada x del bomberman
	 * @param coordenada y del bomberman
	 */
	public GraficaBomberman(int x, int y){
		super(x,y);
		//Inicializo los sprites
		sprites[0] = new ImageIcon(this.getClass().getResource("/Imagenes/Bomberman/Muerto.gif"));
		sprites[1] = new ImageIcon(this.getClass().getResource("/Imagenes/Bomberman/Atras.gif"));
		sprites[2] = new ImageIcon(this.getClass().getResource("/Imagenes/Bomberman/Adelante.gif"));
		sprites[4] = new ImageIcon(this.getClass().getResource("/Imagenes/Bomberman/Derecha.gif"));
		sprites[3] = new ImageIcon(this.getClass().getResource("/Imagenes/Bomberman/Izquierda.gif"));
		sprites[5] = new ImageIcon(this.getClass().getResource("/Imagenes/Bomberman/Quieto.gif"));
		//Seteo la grafica del bomberman quieto por defecto
		grafico=new JLabel(sprites[5]);
		
		}
}
