package Logica.Celdas;

import java.util.Vector;

import Logica.Bomba;
import Logica.Personajes.Bomberman;
import Logica.Personajes.Enemigo;
import Logica.Personajes.Personaje;
import Logica.PowerUp.PowerUp;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */

public class Celda {

    
	// ATRIBUTOS
	
	private int x;
	private int y;   
	private Tablero miTablero;
	private Bomba miBomba;   
	private Pared miPared;
	private Bomberman miBomberman; 
	private Vector<Enemigo> misEnemigos;   
	private PowerUp miPowerUp;   
	private GraficaCelda grafica;

	
	// CONSTRUCTOR   
   
	/**
	 * Crea una celda con una coordenada x e y, y con el tablero al cual esta pertenece.
	 * @param x: coordenada en X de la celda.
	 * @param y: coordenada en Y de la celda.
	 * @param tab: tablero al que pertenece esta celda.
	 */
    public Celda( int x, int y,Tablero tab) {
        miTablero=tab;
        this.x = x;
        this.y = y;
        misEnemigos=new Vector<Enemigo>();
        grafica=new GraficaCelda();
    }

    
    // COMANDOS
    
    /**
     * Retorna la pared que la celda poseea. Si es nula, la celda no posee pared.    
     * @return pared de la celda.
     */
    public Pared getPared() {
    	return miPared;
    }

    /**
     * Devuelve la coordenada X de la celda.
     * @return coordenada X.
     */
    public int getX() {    	
       return x;
    }

    /**
     * Devuelve la coordenada Y de la celda.
     * @return coordenada Y.
     */
    public int getY() {        
        return y;
    }

    /**
     * Agrega una pared (nula o no) a la celda.
     * @param Pared p: pared a añadir.
     */
    public void setPared(Pared p) {
    	if(p == null){
    		miTablero.restarPared();
    		miPared=null;
    	}
    	else miPared = p;
    }
    
    /**
     * Agrega un Bomberman (nulo o no) a la celda.
     * @param Bomberman b: bomberman a añadir.
     */
    public void setBomberman( Bomberman b) {        
    	miBomberman = b;
    }

    /**
     * Agrega un powerUp (nulo o no) a la celda.
     * @param p: powerUp a añadir.
     */
    public void setPowerUp(PowerUp p){    	
    	miPowerUp = p;
    }
    
    
    // CONSULTAS
    
    /**
     * Retorna el powerUp que contiene la celda.
     * @return powerUp de la celda.
     */
    public PowerUp getPowerUp(){    	
    	return miPowerUp;
    }
    
    /**
     * Retorna los enemigos que habitan la celda.
     * @return Vector de enemigos que habitan la celda.
     */
    public Vector<Enemigo> getEnemigos(){    	
    	return misEnemigos;
    }
    
    /**
     * Retorna el Bomberman que habita en la celda.
     * @return Bomberman que habita la celda.
     */
    public Bomberman getBomberman(){
    	return miBomberman;    	
    }

    /**
     * Destruye a los personajes/paredes que se encuentren en una celda.
     */
    public void serExplotada() {
 		if(miPared != null)
    		miPared.destruir();
 		else grafica.serExplotada();
 		int i=0;
    	while(i<misEnemigos.size()){
    			misEnemigos.elementAt(i).morir();
    			i++;
    	}
    	
    	misEnemigos=new Vector<Enemigo>();
    	
    	if(miBomberman != null)
    		miBomberman.morir();
    	
    }
    
    /**
     * Agrega una bomba (nula o no) a la celda.
     * @param b: Bomba a añadir.
     */
    public void setBomba(Bomba b){
    	miBomba = b;
    }

    /**
     * Mueve, si es posible, a un personaje desde su ubicación hacia la celda que se encuentra en dirección "d".
     * @param pers: personaje a mover.
     * @param d: direccion a la que se desea mover al personaje.
     */
    public void mover (Personaje pers, int d){
    	Celda destino = null;
    	switch (d){
			case 1 :{ 
				destino = miTablero.getCelda(x, y-1);
				break;
					}		
			case 2 :{
				destino = miTablero.getCelda(x, y+1);
				break;
				}		
			case 3 :{
				destino = miTablero.getCelda(x-1, y);
				break;
				}		
			case 4 :{
				destino = miTablero.getCelda(x+1, y);
				break;
				}
		}
    	Bomba b=destino.getBomba();
    	Pared p = destino.getPared();
   		if(p!= null){
   				boolean puedeAvanzar = p.serAtravesada(pers);
   				if(puedeAvanzar){
   					pers.cambiarPosicion(destino);
   					pers.getGrafica().mover(d, pers.getVelocidad());
   				}
    		}
    	else if (b == null) {
    					pers.cambiarPosicion(destino);
    			pers.getGrafica().mover(d, pers.getVelocidad());
    			}
    	
   		Vector<Enemigo> enemigos = destino.getEnemigos();
   		Bomberman bomberman = destino.getBomberman();
   		if(!enemigos.isEmpty() && bomberman != null){
   			if(!bomberman.tieneModoDios()){
   				
   				bomberman.morir();
   			} 
   		}
   		PowerUp powerUp = destino.getPowerUp();
   		if(powerUp != null && bomberman != null){
   				bomberman.capturarPowerUp(powerUp);
   				destino.setPowerUp(null);
   		}
    	
    }
    
    /**
     * Retorna las celdas que pueden estar afectadas si ocurre una explosión iniciada en esta celda.
     * @param poder: poder de la explosión.
     * @return arreglo de celdas afectadas por una explosión iniciada en esta celda.
     */
    public Celda[] sectorEnPeligro(int pod){
    	Celda[] sector = new Celda[pod*4+1];
    	int i=1;
    	int corrimiento=1;
    	boolean encontrePared = false; 
    	
    	//AGREGO ESTA CELDA
    	sector[0]=this;
    	
    	// RECORRO A LA DERECHA
    	while (corrimiento <= pod && !encontrePared) {
    		sector[i] = miTablero.getCelda(x+corrimiento,y);
    		corrimiento++;
    		if (sector[i].getPared()!=null)
				encontrePared = true;
    		i++;			
    	}
    	
    	// RECORRO A LA IZQUIERDA
    	encontrePared = false;
    	corrimiento = 1;
    	while (corrimiento <= pod && !encontrePared) {
    		sector[i] = miTablero.getCelda(x-corrimiento,y);
    		corrimiento++;
    		if (sector[i].getPared()!=null)
				encontrePared = true;
    		i++;			
    	}
		
    	// RECORRO HACIA ARRIBA
    	encontrePared = false;
    	corrimiento = 1;
    	while (corrimiento <= pod && !encontrePared) {
    		sector[i] = miTablero.getCelda(x,y+corrimiento);
    		corrimiento++;
    		if (sector[i].getPared()!=null)
				encontrePared = true;
    		i++;			
    	}
    	
		// RECORRO HACIA ABAJO
    	encontrePared = false;
    	corrimiento = 1;
    	while (corrimiento <= pod && !encontrePared) {
    		sector[i] = miTablero.getCelda(x,y-corrimiento);
    		corrimiento++;
    		if (sector[i].getPared()!=null)
				encontrePared = true;
    		i++;			
    	}
    	
    	return sector;
    }
    
    /**
     * Elimina a un enemigo del Vector de enemigos.
     * @param e: enemigo a eliminar
     */
    public void quitarEnemigo(Enemigo e){
    	misEnemigos.removeElement(e);
    }
    
    /**
     * Agrega un enemigo al Vector de enemigos.
     * @param e: enemigo a recibir.
     */
    public void recibirEnemigo(Enemigo e){
    	misEnemigos.addElement(e);
    }
    
    /**
     * Retorna la gráfica de esta celda.
     * @return gráfica de esta celda.
     */
    public GraficaCelda getGrafica(){
    	return grafica;
    }
    
    /**
     * Retorna la bomba de esta celda.
     * @return bomba de esta celda.
     */
    public Bomba getBomba(){
    	return miBomba;
    }
    

    /**
     * Calcula los putnos que retorna la celda en caso de ser explotada
     * @return puntos
     */
    public int calcularPuntos(){
    	int p =0;
    	if(miPared != null)
    		p+= miPared.getValor();
    	for(Enemigo e: misEnemigos){
    		p += e.getValor();
    	}
    	return p;
    }

}