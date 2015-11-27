package Logica;
import Logica.Celdas.*;
import Grafica.GUI;

public class Juego {
	private static GUI gui;
	private static Tablero tab;
	
	public static void main(String []args){
		tab = new Tablero();
		gui = new GUI("BOMBERMAN TDP 15", tab);
			
	}
	
	public static void murioBomberman(){
		gui.juegoTerminado("PERDISTE! Bomberman ha muerto.");
		tab.cortarHilos();	
	}
	
	public static void noHayMasParedes(){
		gui.juegoTerminado("GANASTE! Destruiste todas las paredes.");
		tab.cortarHilos();
	}
		
	
}
