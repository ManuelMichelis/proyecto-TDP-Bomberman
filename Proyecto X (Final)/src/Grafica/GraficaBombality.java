package Grafica;
import javax.swing.*;
/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class GraficaBombality extends GraficaPowerUp{
	
	/**
	 * Inicializa la imagen de la etiqueta grafica de  este power up
	 */
	public GraficaBombality(){
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/PowerUps/Bombality.PNG")));
	}
}
