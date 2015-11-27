package Grafica;

import java.awt.*;
import javax.swing.*;
/**
 * Clase Abstracta Personaje Grafico
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public abstract class GraficaPersonaje {

	// ATRIBUTOS
	protected static final int MUERTO = 0;
	protected static final int ARRIBA = 1;
	protected static final int ABAJO = 2;
	protected static final int DERECHA = 4;
	protected static final int IZQUIERDA = 3;
	protected static final int QUIETO = 5;
	
	protected static final int height = 32;
	protected static final int width = 32;
	
	protected ImageIcon [] sprites;
	protected JLabel grafico;
	protected Point miPosicion;
	
	
	// CONSTRUCTOR
	/**
	 * Constructor de personaje grafico crea un punto con las coordenadas de la etiqueta en pantalla
	 * @param coordenada x del personaje
	 * @param coordenada y del personaje
	 */
	public GraficaPersonaje(int x, int y) {
		miPosicion = new Point(x*32,y*32);
		sprites = new ImageIcon[6];
	}
	//Cada clase grafica se encarga de inicializar sus sprites
	
	// CONSULTAS
	/**
	 * Setea la imagen dependiendo la direccion hacia donde apunta el personaje
	 * @param direccion hacia donde apunta el personaje
	 */
	protected void cambiarImagen(int dir) {
		grafico.setIcon(sprites[dir]);
	}
	/**
	 * Setea la imagen del personaje muerto
	 */
	public void destruir() {
		cambiarImagen(0);
		
}
	
	@SuppressWarnings("static-access")
	/**
	 * Implementa el mover grafico del personaje
	 * @param direccion hacia donde se movera el personaje
	 * @param velocidad con la que se movera el personaje
	 */
	public void mover(int dir,int vel){
		int velocidad=vel;
		cambiarImagen(dir);
		try {
			switch (dir){
				case ARRIBA :  //ARRIBA
					for(int i = 0; i < this.height ; i += velocidad){
						this.grafico.setBounds(this.miPosicion.x, this.miPosicion.y -= velocidad, width, height);
							Thread.sleep(100);
					}	
					break;
					
				case ABAJO : //ABAJO
					for(int i = 0; i < this.height; i += velocidad){
						this.grafico.setBounds(this.miPosicion.x, this.miPosicion.y += velocidad, width, height);
							Thread.sleep(100);
					}	
					break;
					
				case IZQUIERDA : //IZQUIERDA
					for(int i = 0; i < this.height; i += velocidad){
						this.grafico.setBounds(this.miPosicion.x -= velocidad, this.miPosicion.y, width, height);
							Thread.sleep(100);
					}	
					break;
					
				case DERECHA : //DERECHA
					for(int i = 0; i < this.height; i += velocidad){
						this.grafico.setBounds(this.miPosicion.x += velocidad, this.miPosicion.y, width, height);	
						Thread.sleep(100);
					}	
					break;
					
			}
			cambiarImagen(QUIETO);
		} catch (InterruptedException e) {}
	}
	/**
	 * Retorna la etiqueta grafica del personaje
	 * @return etiqueta grafica del personaje
	 */
	public JLabel getGrafico(){
		return grafico;
	}


	
}