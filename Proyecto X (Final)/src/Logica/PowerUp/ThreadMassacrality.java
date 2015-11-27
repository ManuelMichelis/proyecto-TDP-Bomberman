package Logica.PowerUp;

import Logica.Personajes.Bomberman;

public class ThreadMassacrality extends Thread{

	Bomberman bomberman;
	
	public ThreadMassacrality(Bomberman b){
		
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
