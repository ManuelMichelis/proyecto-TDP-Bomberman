package Logica.Personajes;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class BombermanThread extends Thread {

	// ATRIBUTOS
	
	private Bomberman bomberman;
	private volatile boolean detener;
	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un hilo de ejecuci�n para bomberman, d�ndole el bomberman a controlar por medio del hilo.
	 * @param bom: bomberman a controlar por medio del hilo.
	 */
	public BombermanThread(Bomberman bom){
		bomberman=bom;
		detener=false;
	}
	
	// COMANDOS
	
	/**
	 * Inicia la ejecuci�n del hilo de bomberman.
	 */
	public void run(){
		while(!detener){
			if(bomberman.getDireccion()!=0){
				bomberman.getUbicacion().mover(bomberman, bomberman.getDireccion());
				bomberman.setDireccion(0);
			}
			if(bomberman.estaMuerto()){
				detener=true;
			}
		}
	}
	

}
