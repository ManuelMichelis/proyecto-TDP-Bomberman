package Logica.Personajes;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class SiriusThread extends Thread {
	
	// ATRIBUTOS
	
	private Sirius s;
	private volatile boolean detener;
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un hilo de ejecución para un Sirius, dándole el Sirius que ha de controlar.
	 * @param s: Sirius a controlar a través del hilo.
	 */
	public SiriusThread(Sirius s) {
		this.s = s;
		detener = false;
	}
	
	/**
	 * Inicia el hilo de ejecución de un Sirius.
	 */
	public void run() {
		while(!detener){
			try {
				Thread.sleep(1000);
				int direccion = s.pensar();
				s.mover(direccion);
			} catch (InterruptedException e){}
		}
	}
	
	/**
	 * Detiene el hilo de ejecución de un Sirius.
	 */
	public void detener() {
		this.interrupt();
		detener = true;
	}
	
	/**
	 * Destruye el hilo de ejecución de un Sirius.
	 */
	public void destruir() {
		this.detener();
		s.morir();
	}
}