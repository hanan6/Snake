package model;

import java.net.Socket;
import controleur.SocketClient;


/*
 *  Classe representant le joueur et ses informations;
 *  
 */


public class Player {
	
	int score;
	String id;
	int vie;
	int niveau;
	// Snake  snakeJoueur;
	SocketClient socket;
	

	public Player(){
		
		
	}


	
	/*  getters and Setters*/
	
	public SocketClient getSocket() {
		return socket;
	}


	public void setSocket(SocketClient socket) {
		this.socket = socket;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getVie() {
		return vie;
	}


	public void setVie(int vie) {
		this.vie = vie;
	}


	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	


}
