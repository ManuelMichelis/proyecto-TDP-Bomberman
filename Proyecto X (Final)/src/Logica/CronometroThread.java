package Logica;
import javax.swing.JLabel;

import Logica.Personajes.Bomberman;

/**
 * Clase CronometroThread
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */

public class CronometroThread extends Thread{
	
		private JLabel tiempo;
		private boolean detener;
		private Bomberman bomberman;
	
	    public CronometroThread(JLabel tiempo, Bomberman b){
	    	bomberman = b;
	    	this.tiempo = tiempo;
	    	detener = bomberman.estaMuerto();
	    }
	    
	    
	    public void run(){
	    	
	        Integer minutos = 0 , segundos = 0;
	        String min="", seg="";
	 
	        while (!detener){
	        	try {
	        		Thread.sleep(1000);
					segundos++;
	                if( segundos == 60){
	                        segundos = 0;
	                        minutos++;
	                }
	               
	                //Damos formato 00:00
	                if( minutos < 10 )
	                	min = "0" + minutos;
	                else
	                	min = minutos.toString();
	                if( segundos < 10 )
	                	seg = "0" + segundos;
	                else
	                	seg = segundos.toString();

	                //Colocamos en la etiqueta la informacion
	                tiempo.setText("Tiempo: " + min + ":" + seg);
	        	} catch (InterruptedException e) {e.printStackTrace();}
	        	
	        	detener = bomberman.estaMuerto();
	        }
	        
	    }
	
	    
		
		/**
		 * Destruye el hilo de ejecución del cronometro.
		 */
		public void destruir() {
			detener = false;
			this.interrupt();
		}
	    
	    
}
