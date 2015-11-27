package Logica.PowerUp;

import Logica.Personajes.Bomberman;

public class MassacralityThread extends Thread{

	Bomberman bomberman;
	
	public MassacralityThread(Bomberman b){
		
		bomberman = b;
	}
	
	
	public void run(){
		
		try{
			bomberman.setModoDios(true);
			sleep(5000);
			bomberman.setModoDios(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
