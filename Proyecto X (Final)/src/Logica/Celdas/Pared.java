package Logica.Celdas;
import Logica.Personajes.Personaje;
import Grafica.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public abstract class Pared{
	
	// ATRIBUTOS
	
	protected  GraficaPared grafica;
	protected Celda miUbicacion;

	
	// CONSTRUCTOR
	
	/**
	 * Crea una celda con la celda en la cual ella est� ubicada.
	 * @param u: ubicaci�n de la pared.
	 */
    public Pared(Celda u) {
    	miUbicacion=u;
    	
    }

    
    // COMANDOS
    
    /**
     * Destruye, si es posible, la pared.
     */
    public abstract void destruir();
    
    
    // CONSULTAS
    
    /**
     * Permite, si es posible, a un personaje, atravesar la pared.
     * @param p: personaje que desea atravesar la pared.
     * @return
     */
    public abstract boolean serAtravesada(Personaje p);

    /**
     * Retorna el contenido gr�fico de la pared.
     * @return contenido gr�fico de la pared.
     */
    public GraficaPared getGrafica(){
    	return grafica;
    }
    
    /**
     * Retorna el valor de la pared al ser explotada
     * @return valor
     */
    public abstract int getValor();
}

