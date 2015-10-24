package Grafica;

import javax.swing.*;
/**
 * Clase Abstracta Power Up Grafica
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public abstract class GraficaPowerUp {
	
	protected JLabel grafico;
	/**
	 * Constructor de GraficaPowerUp: crea la etiqueta grafica del power up	
	 */
	public GraficaPowerUp(){
			grafico=new JLabel();
		}
	/**
	 * Al afectar al bomberman, la grafica del power up es nula
	 */
	public void afectar(){
		grafico.setIcon(null);
	}
	/**
	 * Retorna la etiqueta grafica del power up
	 * @return etiqueta grafica del power up
	 */
	public JLabel getGrafico(){
		return grafico;
	}
	
		
}
