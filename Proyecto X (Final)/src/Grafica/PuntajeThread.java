package Grafica;

import javax.swing.JLabel;

import Logica.Personajes.Bomberman;

public class PuntajeThread extends Thread{

	
	private JLabel puntaje;
	private Bomberman bomberman;
	private volatile boolean detener;

    public PuntajeThread (JLabel puntaje, Bomberman b){
    	bomberman =b;
    	this.puntaje = puntaje;
    	detener = bomberman.estaMuerto();
    }
    
    
    public void run(){

 
        while (!detener){
        		
                puntaje.setText("Puntaje: "+ bomberman.getPuntaje());
                detener = bomberman.estaMuerto();
        }
        
    }

    
	
	/**
	 * Destruye el hilo de ejecución del cronometro.
	 */
	public void destruir() {
		detener = true;
		this.interrupt();
	}
}
