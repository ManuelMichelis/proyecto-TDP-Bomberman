package Grafica;
import javax.swing.*;


/**
 * Clase Pared Indestructible Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public class GraficaIndestructible extends GraficaPared{
	
	/**
	 * Constructor GraficaIndestructible: crea la etiqueta grafica de la pared indestructible y su imagen
	 */
	public GraficaIndestructible(){	
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/Indestructible.png")));

	}
	/**
	 * Al ser destruida una pared indestructible, no ocurre nada
	 */
	public void destruir(){
	}
	
	
}
