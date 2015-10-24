package Grafica;
import javax.swing.*;
/**
 * Clase Power Up Fatality Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public class GraficaFatality extends GraficaPowerUp{
	
	/**
	 * Inicializa la imagen de la etiqueta grafica de  este power up
	 */
	public GraficaFatality(){
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/PowerUps/Fatality.png")));
	}
}
