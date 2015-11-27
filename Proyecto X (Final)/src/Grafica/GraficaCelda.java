package Grafica;
import javax.swing.*;
/**
 * Clase Celda Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 */
public class GraficaCelda {
	private JLabel grafico;
	private Icon [] sprites;
	
	/**
	 * Constructor de GraficaCelda: crea la etiqueta grafica de la celda y las imagenes.
	 */
	public GraficaCelda(){
		grafico=new JLabel();
		sprites = new Icon[5];
		sprites[0]=new ImageIcon(this.getClass().getResource("/Imagenes/Bomba.gif"));
		sprites[1]=new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.gif"));
	}
	/**
	 * Retorna la etiqueta grafica de la celda
	 * @return Etiqueta grafica de la celda
	 */
	public JLabel getGrafico(){
		return grafico;
	}
	/**
	 * Setea el icono de la celda con fuego tras una explosion
	 */
	public void serExplotada(){
		//grafico=new JLabel(sprites[1]);
		grafico.setIcon(sprites[1]);
	}
	public void sacarExplosion(){
		grafico.setIcon(null);
	}
	/**
	 * Setea el icono de la celda como una bomba tras ser puesta por Bomberman en esa celda
	 */
	public void ponerBomba(){
		//grafico=new JLabel(sprites[0]);
		grafico.setIcon(sprites[0]);
	}
	/**
	 * Quita el icono de bomba de la celda 
	 */
	public void sacarBomba(){
		//grafico=null;
		grafico.setIcon(null);
	}

}
