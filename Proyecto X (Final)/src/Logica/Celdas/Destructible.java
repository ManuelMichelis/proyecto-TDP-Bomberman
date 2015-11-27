package Logica.Celdas;

import Logica.Personajes.Personaje;
import Logica.PowerUp.PowerUp;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Destructible extends Pared {
	
	// CONSTRUCTOR
	
	public Destructible(Celda u) {
    	super(u);
    	grafica=new GraficaDestructible();
    }

	
	// COMANDOS
	
    public void destruir() {
    	miUbicacion.setPared(null);
    	if(miUbicacion.getPowerUp()!=null)
    		miUbicacion.getPowerUp().getGrafica().getGrafico().setVisible(true);
    	grafica.destruir();
    }

    
    // CONSULTAS
    
    
    public boolean serAtravesada(Personaje p) {
        return p.tieneModoDios();
    }


	public int getValor() {
		return 10;
	}
	
	
    

}