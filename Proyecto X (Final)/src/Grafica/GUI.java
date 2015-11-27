package Grafica;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import Logica.CronometroThread;
import Logica.Celdas.*;
import Logica.Personajes.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Michelis Manuel, Pandolfi Manuel, Utizi Sebastian
 */


public class GUI extends JFrame{
	
	private static final int lado=32;
	private static final long serialVersionUID = 1L;
	private Tablero tablero;
	private Container contenedor;
	private Bomberman bomberman;
	private JPanel panelJuego,panelEstado;
	private JLabel lblPuntaje,lblTiempo;
	
	
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
		bomberman = t.getBomberman();
		
		// CONFIGURACIÓN DEL TECLADO (CAPTURA DE EVENTOS DE TECLADO)
		
		addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent arg0) {
				
				if(!bomberman.estaMuerto())
					switch(arg0.getKeyCode()){
						case 32: {bomberman.ponerBomba(); break;}
						case 37: {bomberman.mover(3); break;	}
						case 38: {bomberman.mover(1); break;	}
						case 39: {bomberman.mover(4); break;	}
						case 40: {bomberman.mover(2); break;	}
				}
					
			}
		});
		
		// INICIALIZACIÓN Y UBICACIÓN DE COMPONENTES DE LA GUI
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(874,722);
		setResizable(false);
		contenedor = getContentPane();
		contenedor.setBackground(new Color(222, 184, 135));
		contenedor.setLayout(null);
		
		panelJuego = new JPanel();
		panelJuego.setSize(672,672);
		panelJuego.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelJuego.setBackground(new Color(46, 139, 87));
		panelJuego.setBounds(10, 11, 672, 672);
		contenedor.add(panelJuego);
		panelJuego.setLayout(null);
		
		panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEstado.setBackground(new Color(244, 164, 96));
		panelEstado.setBounds(692, 11, 168, 327);
		contenedor.add(panelEstado);
		panelEstado.setLayout(null);
		
		lblPuntaje = new JLabel("PUNTAJE: 0");
		lblPuntaje.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblPuntaje.setBounds(10, 32, 142, 26);
		PuntajeThread puntaje = new PuntajeThread(lblPuntaje,bomberman);
		panelEstado.add(lblPuntaje, bomberman);
		puntaje.start();
		
		lblTiempo = new JLabel("TIEMPO:");
		lblTiempo.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblTiempo.setBounds(10, 112, 142, 33);
		panelEstado.add(lblTiempo);
		CronometroThread cronometro = new CronometroThread(lblTiempo,bomberman);
		cronometro.start();
			
		JLabel imgBomberman = new JLabel("");
		imgBomberman.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Bomberman/Quieto.gif")));
		imgBomberman.setBounds(10, 258, 28, 45);
		panelEstado.add(imgBomberman);
		
		JLabel imgRugulos = new JLabel("");
		imgRugulos.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Azul/Quieto.gif")));
		imgRugulos.setBounds(48, 258, 28, 44);
		panelEstado.add(imgRugulos);
		
		JLabel imgSirius = new JLabel("");
		imgSirius.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Negro/Quieto.gif")));
		imgSirius.setBounds(86, 258, 28, 45);
		panelEstado.add(imgSirius);
		
		JLabel imgAltair = new JLabel("");
		imgAltair.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Rojo/Quieto.gif")));
		imgAltair.setBounds(124, 258, 28, 45);
		panelEstado.add(imgAltair);
		
		//INICIALIZAMOS TODOS LOS COMPONENTES GRÁFICOS DEL JUEGO
		inicializarImagenes();
		setVisible(true);
	}
	
	
	/**
	 * INICIALIZA EN LA VENTANA TODAS LAS COMPONENTES GRÁFICAS DEL JUEGO (CELDAS, PAREDES Y PERSONAJES).
	 */
	
	public void inicializarImagenes(){
		for(int i=0;i<21;i++)
			for(int j=0;j<21;j++){
				// RECORRE CADA CELDA DEL TABLERO. SI EXISTEN ENEMIGOS, DIBUJA A CADA UNO DE ELLOS.
				if(!tablero.getCelda(i, j).getEnemigos().isEmpty()){
					Iterator<Enemigo> it=tablero.getCelda(i, j).getEnemigos().iterator();
					while(it.hasNext()){
						JLabel labelaux=it.next().getGrafica().getGrafico();
						panelJuego.add(labelaux);
						labelaux.setBounds(i*lado, j*lado, lado, lado);
					}	
				}
			}
		for(int i=0;i<21;i++)
			for(int j=0;j<21;j++){
				
				
				panelJuego.add(tablero.getCelda(i, j).getGrafica().getGrafico());
				tablero.getCelda(i, j).getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				
				
				
				if(tablero.getCelda(i, j).getPared()!=null){
					panelJuego.add(tablero.getCelda(i, j).getPared().getGrafica().getGrafico());
					tablero.getCelda(i, j).getPared().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				
				//Aca se ponen los powerups graficos
				if(tablero.getCelda(i, j).getPowerUp()!=null){
					panelJuego.add(tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico());
					tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
					tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico().setVisible(false);
				}
				
				//Si hay un bomberman lo grafico
				if(tablero.getCelda(i, j).getBomberman()!=null){
					panelJuego.add(tablero.getCelda(i, j).getBomberman().getGrafica().getGrafico());
					tablero.getCelda(i, j).getBomberman().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				
								
			}
		
		JLabel lblFondoTablero = new JLabel("piso");
		lblFondoTablero.setBounds(0, 0, 834, 677);
		panelJuego.add(lblFondoTablero);
		lblFondoTablero.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/Fondo.png")));
		
		JLabel lblFondoEstado = new JLabel();
		panelEstado.add(lblFondoEstado);
		lblFondoEstado.setBounds(0,0, 168, 327);		
		lblFondoEstado.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/FondoEstado.jpg")));
		
		JLabel lblFondoContenedor = new JLabel();
		lblFondoContenedor.setBounds(0,0,880,744);
		contenedor.add(lblFondoContenedor);
		lblFondoContenedor.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/FondoContenedor.jpg")));
		
	}
		
	public void juegoTerminado(String s){
		
			JOptionPane.showMessageDialog(null,s);
	}
}
