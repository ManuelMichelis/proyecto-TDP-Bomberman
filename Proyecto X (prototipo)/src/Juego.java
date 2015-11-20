import Logica.Celdas.*;
import Grafica.GUI;
import Logica.Personajes.*;
public class Juego {
	
	private static Enemigo[] malos=new Enemigo[6];
	public static void main(String []args){
		
		//Creamos tablero
		Tablero tab=new Tablero();
		//Inicializamos el tablero
		tab.inicializarTablero();
		
		// CREAMOS A BOMBERMAN
		Bomberman bomberman=new Bomberman(tab.getCelda(1, 1));
		tab.getCelda(1, 1).setBomberman(bomberman);
		
		// CREAMOS LOS RUGULOS
		int i=0;
		Rugulos rugulos1 =new Rugulos(tab.getCelda(15, 1),bomberman);
		tab.getCelda(15, 1).recibirEnemigo(rugulos1);
		malos[i++]=rugulos1;
		Rugulos rugulos2 =new Rugulos(tab.getCelda(15, 1),bomberman);
		tab.getCelda(15, 1).recibirEnemigo(rugulos2);
		malos[i++]=rugulos2;
		Rugulos rugulos3 =new Rugulos(tab.getCelda(15, 1),bomberman);
		tab.getCelda(15, 1).recibirEnemigo(rugulos3);
		malos[i++]=rugulos3;
		
		// CREAMOS LOS ALTAIR
		Altair altair1 =new Altair(tab.getCelda(15, 1),bomberman);
		tab.getCelda(15, 1).recibirEnemigo(altair1);
		malos[i++]=altair1;
		Altair altair2 =new Altair(tab.getCelda(15, 1),bomberman);
		tab.getCelda(15, 1).recibirEnemigo(altair2);
		malos[i++]=altair2;		
		
		// CREAMOS EL SIRIUS
		Sirius sirius =new Sirius(tab.getCelda(19,19),bomberman);
		tab.getCelda(19,19).recibirEnemigo(sirius);
		malos[i++]=sirius;
		
		GUI gui =new GUI("Bomberman",tab);
		gui.setBomberman(bomberman);
		
//		gui.add(rugulos1.getGrafica().getGrafico());
		//Ejecutamos los hilos de los enemigos (por ahora solo un rugulus)
		ejecutarHilos(tab,malos,bomberman);
	}

	
	private static void ejecutarHilos(Tablero tab,Enemigo[] malos,Bomberman bom){
		
		bom.ejecutarHilo();
		for(Enemigo e:malos)
			e.ejecutarHilo();
	}
}
