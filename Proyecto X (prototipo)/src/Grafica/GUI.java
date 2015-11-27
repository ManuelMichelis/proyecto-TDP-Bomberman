package Grafica;
import javax.swing.*;
import javax.swing.border.LineBorder;

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
	private JPanel panelJuego,panelEstado;
	private JLabel puntaje,tiempo;
	private JMenuBar menu;
	private JMenu menuJuego,menuOpciones;
	private JMenuItem menuItemNuevo,menuItemSalir,menuItemControles;
		
	
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
			public void keyPressed(KeyEvent arg0) {
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
		
		setSize(880,744);
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
		panelEstado.setBounds(696, 11, 168, 672);
		contenedor.add(panelEstado);
		panelEstado.setLayout(null);
		
		puntaje = new JLabel("PUNTAJE:");
		puntaje.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		puntaje.setBounds(10, 32, 122, 26);
		panelEstado.add(puntaje);
		
		tiempo = new JLabel("TIEMPO:");
		tiempo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		tiempo.setBounds(10, 244, 122, 33);
		panelEstado.add(tiempo);
		
		menu = new JMenuBar();
		menu.setBackground(UIManager.getColor("Button.shadow"));
		setJMenuBar(menu);
		
		menuJuego = new JMenu("Juego");
		menu.add(menuJuego);
		
		menuItemNuevo = new JMenuItem("Nuevo juego");
		menuJuego.add(menuItemNuevo);
		
		menuItemSalir = new JMenuItem("Salir");
		menuJuego.add(menuItemSalir);
		
		menuOpciones = new JMenu("Opciones");
		menu.add(menuOpciones);
		
		menuItemControles = new JMenuItem("Controles");
		menuOpciones.add(menuItemControles);
		
		
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
				panelJuego.add(tablero.getCelda(i, j).getGrafica().getGrafico());
				tablero.getCelda(i, j).getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				
				if(!tablero.getCelda(i, j).getEnemigos().isEmpty()){
					Iterator<Enemigo> it=tablero.getCelda(i, j).getEnemigos().iterator();
					while(it.hasNext()){
						JLabel labelaux=it.next().getGrafica().getGrafico();
						panelJuego.add(labelaux);
						labelaux.setBounds(i*lado, j*lado, lado, lado);
					}	
				}
				
				if(tablero.getCelda(i, j).getPared()!=null){
					panelJuego.add(tablero.getCelda(i, j).getPared().getGrafica().getGrafico());
					tablero.getCelda(i, j).getPared().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				if(tablero.getCelda(i, j).getPowerUp()!=null){
					panelJuego.add(tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico());
					tablero.getCelda(i, j).getPowerUp().getGrafica().getGrafico().setBounds(i*lado,j*lado,lado,lado);
				}
				if(tablero.getCelda(i, j).getBomberman()!=null){
					panelJuego.add(tablero.getCelda(i, j).getBomberman().getGrafica().getGrafico());
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
