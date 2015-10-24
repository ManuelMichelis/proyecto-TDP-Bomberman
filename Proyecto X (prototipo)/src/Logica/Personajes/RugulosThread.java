package Logica.Personajes;
import java.util.Random;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class RugulosThread extends Thread {
	
	// ATRIBUTOS
	
	private Rugulos r;
	private volatile boolean detener;
	private Random rnd = new Random(4);
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un hilo de ejecución para un Rugulos.
	 * @param r: rugulos a controlar por medio del hilo.
	 */
	public RugulosThread(Rugulos r) {
		this.r = r;
		detener = false;
	
	}
	
	
	// COMANDOS
	
	/**
	 * Inicia la ejecución del hilo de Rugulos.	
	 */
	public void run() {
		
		while(!detener){
			
			try {
				Thread.sleep(100);
				int direc=rnd.nextInt(1024);
				r.mover(direc%4+1);
				if(r.getEnemigo().estaMuerto()){
					destruir();
					detener=true;
				}
			} catch (InterruptedException e){}
		}
	}
	
	/**
	 * Detiene el hilo de ejecución de un Rugulos.
	 */
	public void detener() {
		this.interrupt();
		detener = true;
	}
	
	/**
	 * Destruye el hilo de ejecución de un Rugulos.
	 */
	public void destruir() {
		this.detener();
		r.morir();
	}
}