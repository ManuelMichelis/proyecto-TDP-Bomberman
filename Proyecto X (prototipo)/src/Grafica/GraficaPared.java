package Grafica;
import javax.swing.*;
/**
 * Clase Abstracta Pared Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public abstract class GraficaPared {
	
	protected JLabel grafico;
	/**
	 * Cada pared debe implementar su destruir grafico	
	 */
	public abstract void destruir();
	
	/**
	 * Retorna la etiqueta de la pared
	 * @return etiqueta de pared
	 */
	public JLabel getGrafico(){
		return grafico;
	}
	
}
