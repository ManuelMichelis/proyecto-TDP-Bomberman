package Logica.Personajes;
import java.util.Random;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class AltairThread extends EnemigosThread {
	
	// ATRIBUTOS
	
	private Altair a;
	private volatile boolean detener;
	private Random rnd = new Random();
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un hilo de ejecución para un Rugulos.
	 * @param r: rugulos a controlar por medio del hilo.
	 */
	public AltairThread(Altair a) {
		this.a = a;
		detener = false;
	
	}
	
	
	// COMANDOS
	
	/**
	 * Inicia la ejecución del hilo de Rugulos.	
	 */
	public void run() {
		
		while(!detener){
			
			try {
				sleep(100);
				int direc=rnd.nextInt(1024);
				a.mover(direc%4+1);
			} catch (InterruptedException e){}
		}
	}
	
	/**
	 * Detiene el hilo de ejecución de un Rugulos.
	 */
	public void detener() {
		this.interrupt();
	}
	
	/**
	 * Destruye el hilo de ejecución de un Rugulos.
	 */
	public void destruir() {
		a.getGrafica().getGrafico().setIcon(null);
		detener = true;
		this.detener();
	
	}
}