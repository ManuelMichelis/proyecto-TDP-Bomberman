package Logica.Celdas;
import java.util.Random;
import Logica.PowerUp.Fatality;
import Logica.PowerUp.*;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian.
 */
public class Tablero {
	
	// ATRIBUTOS
	
	protected Celda[][] misCeldas;
	
	
	// CONSTRUCTOR
	
	/**
	 * Construye un tablero de 21 x 21 celdas.
	 */
	public Tablero(){
		misCeldas=new Celda[21][21];
		inicializarTablero();
	}
	
	
	// COMANDOS
	
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
				//POR AHORA COMENTAMOS LO DE AQUI ABAJO YA QUE NO HABRA PAREDES DESTRUCTIBLES, MAS ADELANTE LO PONDREMOS
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
		
	}
	
	
	// CONSULTAS
	
	/*
	 * Retorna true si i y j son pares, y falso en caso contrario
	 */
	private boolean sonPares(int i,int j){
		return i%2==0 && j%2==0;
	}
	
	/*
	 * Retorna true si la celda en i j es borde y falso en caso contrario
	 */
	private boolean esBorde(int i,int j){
		if(i==0 || j ==0 || i==20 || j==20)
			return true;
		return false;
	}
	
	/*
	 * Retorna true si la posicion i,j es donde nace un bicho
	 */
	private boolean esSpawn(int i,int j){
		if ((i==1 && j==1) || (i==1 && j==2) || (i==2 && j==1) ||
			(i==19 && j==19) || (i==19 && j==18) || (i==18 && i==19))
				
			return true;
		return false;
	}
	
	/*
	 * Retorna true si faltan poner powerups o falso en caso contrario
	 */
	private boolean faltanPw(int [] powerUpsRestantes){
		for(int i=0;i<4;i++)
			if(powerUpsRestantes[i]>0)
				return true;
		return false;
	}
	
	/*
	 * Inserta un power un power up del tipo indicado en la celda indicada
	 * 1=speedup	2=fatality		3=bombality		4=masacrality
	 */
	

	/*
	 *Retorna la celda de la posicion x,y o null si es una posicion que no
	 *pertenece al tablero
	 */
	public Celda getCelda(int x,int y){
		if(x>=0 && y>=0 && x<21 && y<21)
			return misCeldas[x][y];	
		else return null;
	}

}