package Grafica;
import javax.swing.*;
/**
 * Clase Power Up SpeedUp Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public class GraficaSpeedUp extends GraficaPowerUp{
	
	/**
	 * Inicializa la imagen de la etiqueta grafica de  este power up
	 */
	public GraficaSpeedUp(){
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/PowerUps/SpeedUp.PNG")));
	}
}
