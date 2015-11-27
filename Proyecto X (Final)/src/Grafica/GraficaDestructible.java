package Grafica;
import javax.swing.*;
/**
 * Clase Pared Destructible Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public class GraficaDestructible extends GraficaPared{
	
	/**
	 * Constructor GraficaDestructible: crea la etiqueta grafica de la pared destructible y su imagen
	 */
	public GraficaDestructible(){	
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Tree.png")));
	}
	/**
	 * Al ser explotada una pared, setea su imagen como nula
	 */
	public void destruir(){
		grafico.setIcon(null);
	}
	
	
}
