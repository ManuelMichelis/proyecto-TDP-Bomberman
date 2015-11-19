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
		setSize(850,706);
		setResizable(false);
		setLocation(400,0);
		contenedor.setBackground(new Color(0, 128, 0));	
		contenedor.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(680, 0, 164, 677);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puntaje : ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 138, 81, 26);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel lblTiempo = new JLabel("Tiempo : ");
		lblTiempo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setBounds(10, 175, 81, 26);
		panel.add(lblTiempo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Bomberman/Quieto.gif")));
		label.setBounds(10, 258, 28, 45);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Azul/Quieto.gif")));
		label_1.setBounds(48, 258, 28, 44);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Negro/Quieto.gif")));
		label_2.setBounds(86, 258, 28, 45);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Rojo/Quieto.gif")));
		label_3.setBounds(124, 258, 28, 45);
		panel.add(label_3);
		
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
				
				if(!tablero.getCelda(i, j).getEnemigos().isEmpty()){
					Iterator<Enemigo> it=tablero.getCelda(i, j).getEnemigos().iterator();
					while(it.hasNext()){
						JLabel labelaux=it.next().getGrafica().getGrafico();
						contenedor.add(labelaux);
						labelaux.setBounds(i*lado, j*lado, lado, lado);
					}	
				}
				
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
