import Logica.Celdas.*;
import Grafica.GUI;
import Logica.Personajes.*;
public class Juego {
	
	
	public static void main(String []args){
		
		//Creamos tablero
		Tablero tab=new Tablero();
		//Inicializamos el tablero
		tab.inicializarTablero();
		
		//Creamos al bomberman
		Bomberman bomberman=new Bomberman(tab.getCelda(1, 1));
		tab.getCelda(1, 1).setBomberman(bomberman);
		
		//Creamos los enemigos (por ahora solo un rugulus)
		Rugulos rugulos1 =new Rugulos(tab.getCelda(15, 1),bomberman);
		tab.getCelda(15, 1).setEnemigo(rugulos1);
		
		
		GUI gui =new GUI("Bomberman",tab);
		gui.setBomberman(bomberman);
		
//		gui.add(rugulos1.getGrafica().getGrafico());
		//Ejecutamos los hilos de los enemigos (por ahora solo un rugulus)
		ejecutarHilos(tab,rugulos1,bomberman);
	}

	
	private static void ejecutarHilos(Tablero tab,Rugulos rug,Bomberman bom){
		
		bom.ejecutarHilo();
		rug.ejecutarHilo();
	}
}
