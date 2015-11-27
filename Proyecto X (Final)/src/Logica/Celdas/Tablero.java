package Logica.Celdas;
import java.util.Random;

import Logica.Juego;
import Logica.Personajes.Altair;
import Logica.Personajes.Bomberman;
import Logica.Personajes.Enemigo;
import Logica.Personajes.Rugulos;
import Logica.Personajes.Sirius;
import Logica.PowerUp.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Tablero {
	
	// ATRIBUTOS
	
	protected Celda[][] misCeldas;
	protected Bomberman miBomberman;
	protected int paredesRestantes;
	protected Enemigo [] misEnemigos;
	
	// CONSTRUCTOR
	
	/**
	 * Construye un tablero de 21 x 21 celdas.
	 */
	public Tablero(){
		misCeldas=new Celda[21][21];
		paredesRestantes =138;
		misEnemigos = new Enemigo[6];
		inicializarTablero();
	}
	
	
	// COMANDOS
	/*
	 * Inserta un power up del tipo indicado en la celda indicada (TIPOS: 1=speedup, 2=fatality, 3=bombality y 4=masacrality)
	 */
	private void ponerPw(Celda c,int tipo,int[] pwRestantes){
		switch (tipo){
		
			case 0:{c.setPowerUp(new SpeedUp());break;}
			case 1:{c.setPowerUp(new Fatality());break;}
			case 2:{c.setPowerUp(new Bombality());break;}
			case 3:{c.setPowerUp(new Masacrality());break;}
		}
		pwRestantes[tipo]--;
	}
	
	
	/*
	 * Inicializa las celdas, las paredes destrubtubles, 
	 * las paredes indestructibles y los powerups		
	 */
	
	public void inicializarTablero(){
		//Inicializamos cada pieza del tablero como una nueva celda
		for(int i=0;i<21;i++)
			for(int j=0;j<21;j++){
				misCeldas[i][j]=new Celda(i,j,this);
				//Inicializamos paredes indestructibles
				if(sonPares(i,j) || esBorde(i,j))
					misCeldas[i][j].setPared(new Indestructible(misCeldas[i][j]));
				if(i==0)
					misCeldas[i][j].setPared(new Indestructible(misCeldas[i][j]));
				
			}
		
		//Inicializamos paredes destruibles
		Random rnd;
		rnd=new Random();
		int x;
		int y;
		int destructiblesRestantes=138;
		int []pwRestantes={3,3,3,1};
		while(destructiblesRestantes>0){
			x=rnd.nextInt(21);
			y=rnd.nextInt(21);
			if(!sonPares(x,y) && !esBorde(x,y) && !esSpawn(x,y)){
				misCeldas[x][y].setPared(new Destructible(misCeldas[x][y]));
				destructiblesRestantes--;
				
				//Inicializamos powerUps
				if(faltanPw(pwRestantes)){
					int tipo=rnd.nextInt(4);
					while(pwRestantes[tipo]<1)
						tipo=(tipo+1)%4;
					ponerPw(misCeldas[x][y],tipo,pwRestantes);
				}
			}
		}
		inicializarPersonajes();
	}
	
	
	// CONSULTAS
	
	 /**
	  * Retorna true si x y y son pares, o falso, en caso contrario.
	  * @param x: coordenada X de una celda del tablero.
	  * @param y: coordenada Y de una celda del tablero.
	  * @return true si x y y son pares, o falso, en caso contrario.
	  */
	 
	private boolean sonPares(int x,int y){
		return x%2==0 && y%2==0;
	}
	
	/**
	 * Retorna true si la celda en (i,j) es borde, y falso, en caso contrario.
	 * @param i: coordenada X de una celda del tablero.
	 * @param j: coordenada Y de una celda del tablero.
	 * @return true si la celda en (i,j) es borde, y falso, en caso contrario.
	 */	 
	private boolean esBorde(int x,int y){
		return x==0 || y ==0 || x==20 || y==20;
	}
	
	/**
	 * Retorna true si la posicion (x,y) es donde se coloca un personaje o false, en caso contrario.
	 * @param x: coordenada X de una celda del tablero.
	 * @param y	coordenada Y de una celda del tablero.
	 * @return true si la posicion (x,y) es donde se coloca un personaje o false, en caso contrario.
	 */
	
	private boolean esSpawn(int x,int y) {
		boolean superiorDerecha = x==19 && y==1 || x==18 && y ==1 || x==19 && y==2; 
		boolean superiorIzquierda = x==1 && y==1 || x==2 && y ==1 || x==1 && y==2;
		boolean medioDerecha = x==19 && y==10 || x==19 && y ==9 || x==19 && y==11;
		boolean centro = x==11 && y==10 || x==11 && y ==9 || x==10 && y==9;
		boolean medioIzquierda = x==1 && y==10 || x==1 && y ==9 || x==1 && y==11;
		boolean inferiorDerecha = x==19 && y==19 || x==18 && y ==19 || x==19 && y==18;
		boolean inferiorMedia = x==10 && y==19 || x==9 && y ==19 || x==11 && y==19;
		boolean inferiorIzquierda = x==1 && y==19 || x==1 && y ==18 || x==2 && y==19;		
		return superiorDerecha || superiorIzquierda || medioDerecha || 	centro || medioIzquierda || inferiorDerecha || inferiorMedia || inferiorIzquierda;
	}
	
	/**
	 * Retorna true si faltan poner powerups o false, en caso contrario.
	 * @param powerUpsRestantes: powerUps que restan colocar, de acuerdo a su tipo, dado por un entero (detallados en la linea 39)
	 * @return true si faltan poner powerups o false, en caso contrario.
	 */
	
	private boolean faltanPw(int [] powerUpsRestantes) {
		int i=0;
		boolean faltan = false;
		while (i < powerUpsRestantes.length && !faltan) {
			if(powerUpsRestantes[i]>0)
				faltan = true;
			i++;
		}
		return faltan;
	}
	
	
	

	/**
	 * Retorna la celda de la posicion (x,y) si esta existe, o null en caso contrario.
	 * @param x: coordenada X de la celda a retornar.
	 * @param y: coordenada Y de la celda a retornar.
	 * @return celda del tablero si existe en la posicion (x,y) o nulo, en caso contrario.
	 */
	 
	public Celda getCelda(int x,int y){
		if(x>=0 && y>=0 && x<21 && y<21)
			return misCeldas[x][y];	
		else return null;
	}

	/**
	 * Inicializa los personajes y los inserta en el tablero
	 */
	
	private void inicializarPersonajes(){
		
		
		// CREAMOS A BOMBERMAN
		miBomberman = new Bomberman(misCeldas[1][1]);
		misCeldas[1][1].setBomberman(miBomberman);
		
		// CREAMOS LOS RUGULOS
		int i=0;
		
		Rugulos rugulos1 =new Rugulos(misCeldas[18][1],miBomberman);
		misCeldas[18][1].recibirEnemigo(rugulos1);
		misEnemigos[i++]=rugulos1;
		Rugulos rugulos2 =new Rugulos(misCeldas[11][10],miBomberman);
		misCeldas[11][10].recibirEnemigo(rugulos2);
		misEnemigos[i++]=rugulos2;
		Rugulos rugulos3 =new Rugulos(misCeldas[1][19],miBomberman);
		misCeldas[1][19].recibirEnemigo(rugulos3);
		misEnemigos[i++]=rugulos3;
		
		// CREAMOS LOS ALTAIR
		Altair altair1 =new Altair(misCeldas[10][19],miBomberman);
		misCeldas[10][19].recibirEnemigo(altair1);
		misEnemigos[i++]=altair1;
		Altair altair2 =new Altair(misCeldas[10][1],miBomberman);
		misCeldas[10][1].recibirEnemigo(altair2);
		misEnemigos[i++]=altair2;		
		
		// CREAMOS EL SIRIUS
		Sirius sirius =new Sirius(misCeldas[19][19],miBomberman);
		misCeldas[19][19].recibirEnemigo(sirius);
		misEnemigos[i++]=sirius;
		
		//Ejecutamos los hilos de los enemigos
		ejecutarHilos(misEnemigos,miBomberman);
	}

	/**
	 * Ejecuta los hilos de los personajes del tablero.
	 * @param malos: enemigos del tablero.
	 * @param bom: Bomberman del tablero.
	 */
	private void ejecutarHilos(Enemigo[] malos,Bomberman bom){		
		bom.ejecutarHilo();
		for(Enemigo e:malos)
			e.ejecutarHilo();
	}
	
	/**
	 * Retorna el personaje Bomberman que pertenece al tablero.
	 */
	public Bomberman getBomberman(){
		return miBomberman;
	}
	
	/**
	 * decrementa la cantidad de paredes destructibles que hay en el tablero.
	 */
	public void restarPared(){
		paredesRestantes--;
		if(paredesRestantes==0)
			Juego.noHayMasParedes();
	}
	
	/**
	 * Corta los hilos de ejecución de todos los personajes.
	 */
	public void cortarHilos(){
		miBomberman.cortarHilo();
		for (Enemigo e: misEnemigos){
			e.cortarHilo();
		}
	}
}

