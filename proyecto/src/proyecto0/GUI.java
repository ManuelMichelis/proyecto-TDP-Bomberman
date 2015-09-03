package proyecto0;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class GUI extends JFrame {
	
	public GUI (String tit) {
		super(tit);
		setResizable(false);
		getContentPane().setBackground(new Color(30, 144, 255));
		getContentPane().setLayout(null);
		setSize(676,409);
		// TITULO DEL PROYECTO
		JLabel titulo = new JLabel("Proyecto 0");
		titulo.setBackground(new Color(30, 144, 255));
		titulo.setFont(new Font("Papyrus", Font.BOLD, 40));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setBounds(10, 11, 212, 64);
		getContentPane().add(titulo);
		// FRASE DEL PERSONAJE
		JTextPane frase = new JTextPane();
		frase.setEditable(false);
		frase.setBackground(new Color(30, 144, 255));
		frase.setForeground(new Color(0, 0, 0));
		frase.setFont(new Font("Papyrus", Font.PLAIN, 18));
		frase.setText("");
		frase.setBounds(10, 224, 230, 145);
		getContentPane().add(frase);
		// BOTÓN PARA MOSTRAR LA FRASE DEL PERSONAJE
		JButton botonFrase = new JButton("Frase de Homero");
		botonFrase.setForeground(new Color(0, 0, 0));
			// ACCIÓN QUE PRODUCE EL BOTÓN
			botonFrase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frase.setText("\"Ped\u00ED a Dios una bicicleta, pero como se que Dios no funciona as\u00ED, rob\u00E9 una bicicleta y ped\u00ED perd\u00F3n a Dios\"");
				}
			});
		botonFrase.setFont(new Font("Papyrus", Font.PLAIN, 23));
		botonFrase.setBackground(new Color(30, 144, 255));
		botonFrase.setBounds(10, 176, 230, 37);
		getContentPane().add(botonFrase);
		// IMAGEN DEL PERSONAJE (FONDO)
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/Imagen/homero.jpg")));
		label.setBounds(0, 0, 670, 380);
		getContentPane().add(label);
		
		//		
	}
}