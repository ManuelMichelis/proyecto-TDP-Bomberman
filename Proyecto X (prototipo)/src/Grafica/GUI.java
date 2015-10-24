package Grafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import Logica.Celdas.*;
import Logica.Personajes.*;

/**
 * Clase GUI
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 *
 */
public class GUI extends JFrame{
	
	private static final int lado=32;
	private static final long serialVersionUID = 1L;
	private Tablero tablero;
	private Container contenedor;
	private Bomberman bomberman;
	
	/**
	 * Constructor de la GUI:
	 * -Inicializa el tablero
	 * -Captura los eventos por teclado
	 * -Setea las configuraciones de la ventana
	 * @param nombre de la ventana s
	 * @param tablero t del juego
	 */
	public GUI(String s,Tablero t){
		super(s);		
		tablero=t;
		//Evento por teclado
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				/*
				 * Arriba es > 38
					Abajo es > 40
					Derecha es > 39
					Izquierda es > 37
					Space es > 32
				 */
				if(!bomberman.estaMuerto())
					switch(arg0.getKeyCode()){
						case 32: {bomberman.ponerBomba(); break;}
						case 37: {bomberman.mover(3); break;	}
						case 38: {bomberman.mover(1); break;	}
						case 39: {bomberman.mover(4); break;	}
						case 40: {bomberman.mover(2); break;	}
				}
				else {
					
					JOptionPane.showMessageDialog(null,"Perdiste. Bomberman esta muerto."); 
				}	
			}
		});
		//Seteamos las configuraciones de la ventana de la GUI
		contenedor=this.getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(680,706);
		setResizable(false);
		setLocation(400,0);
		contenedor.setBackground(new Color(0, 128, 0));	
		contenedor.setLayout(null);
		
		//Inicializamos todos los graficos
		inicializarImagenes();
		setVisible(true);
	}
	/**
	 * Inicializa en la ventana todas las imagenes graficas del juego presentes (celdas, paredes,bomberman, enemigos)
	 */
	public void inicializarImagenes(){
		for(int i=0;i<21;i++)
			for(int j=0;j<21;j++){
				contenedor.add(tablero.getCelda(i, j).getGrafica().getGrafico());
				tablero.getCelda(i, j).getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				
				if(tablero.getCelda(i, j).getPared()!=null){
					contenedor.add(tablero.getCelda(i, j).getPared().getGrafica().getGrafico());
					tablero.getCelda(i, j).getPared().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				if(tablero.getCelda(i, j).getPowerUp()!=null){
					contenedor.add(tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico());
					tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				if(tablero.getCelda(i, j).getBomberman()!=null){
					contenedor.add(tablero.getCelda(i, j).getBomberman().getGrafica().getGrafico());
					tablero.getCelda(i, j).getBomberman().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				if(!tablero.getCelda(i, j).getEnemigos().isEmpty()){
					Iterator<Enemigo> it=tablero.getCelda(i, j).getEnemigos().iterator();
					while(it.hasNext()){
						JLabel labelaux=it.next().getGrafica().getGrafico();
						contenedor.add(labelaux);
						labelaux.setBounds(i*lado, j*lado, lado, lado);
					}	
				}				
			}
	}
	/**
	 * Setea el bomberman del juego
	 * @param Bomberman b del juego
	 */
	public void setBomberman(Bomberman b){
		bomberman=b;
	}

}
