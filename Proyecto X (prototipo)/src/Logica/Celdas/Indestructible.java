package Logica.Celdas;

import Logica.Personajes.Personaje;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Indestructible extends Pared {

	// CONSTRUCTOR
	
    public Indestructible(Celda u) {
    	super(u);
    	grafica=new GraficaIndestructible();
    }
    
    // COMANDOS
    
    public void destruir() {
    	//Las paredes indestructibles no pueden ser destruidas
    }

    
    // CONSULTAS
    
    public boolean serAtravesada(Personaje p) {
        //Las paredes indestructibles no pueden ser atravesadas por ningun personaje
    	return false;
    }

}