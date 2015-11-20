package Logica;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class BombaThread extends Thread {
	
	
	// ATRIBUTOS
	
	private volatile boolean detener=false;
	private Bomba b;
		
	
	// CONSTRUCTOR
	
	/**
	 * Crea un hilo de ejecución para una bomba.
	 * @param b: bomba a controlar en el hilo de ejecución.
	 */
	public BombaThread(Bomba b) {
		this.b = b;
	}
	
	
	// COMANDOS
	
	/**
	 * Inicia el hilo de ejecución de una bomba.
	 */
	public void run() {
		try {
			while(!detener){
					b.getUbicacion().getGrafica().ponerBomba();
					Thread.sleep(5000);
					b.getUbicacion().getGrafica().sacarBomba();
					for(int i=0; i  <b.getAlcance().length; i++) {
						if(b.getAlcance()[i]!=null)
							b.getAlcance()[i].serExplotada();
					}
					b.getUbicacion().setBomba(null);
					
					b.getDueño().sumarCantBombasSimult(); 
					Thread.sleep(2000);
					for(int i=0; i<b.getAlcance().length; i++)
						if(b.getAlcance()[i]!=null)
							b.getAlcance()[i].getGrafica().sacarExplosion();
					detener=true;
			}
		
			} catch (InterruptedException e){}
		}
	
}