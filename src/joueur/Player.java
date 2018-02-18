package joueur;

import java.awt.event.KeyEvent;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import client_server.SocketClient;



/*
 *  Classe representant le joueur et ses informations;
 *  
 */


public class Player {
	
	int score;
	String id;
	int vie;
	private int niveau;
	// Snake  snakeJoueur;
	SocketClient socket;
	
	int[][] matrice_jeu= new int[10][5];
	
	private  PositionJoueur pos;
	
	

	public Player(){
		pos= new PositionJoueur(); // Initilisation de la position du joeur
		
	}


	
	/* --------------------------- getters and Setters---------------*/
	
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
	
	
	/* --------------------------- -------------------------*/
	
	
	/**
	 *  Gestion de la connexion entre Client et server 
	 *  @param serverAdress: adresse du serveur
	 *  @param port: port de communication avec le serveur
	 *  */
	
	public void demandeConnexion(String serverAdress,int port){
		
		 socket= new SocketClient();
		 
		
		 
		 
		 socket.connexion(serverAdress, port);
		 socket.envoyereMessage(pos);
		
		
	}
	
	 public static void main(String args[]){
		 
		 
		 /*
		  *  Instanciation d'un personne/joueur et demande de connexion  sur le serveur
		  */
		 Player p1= new Player();
		 p1.demandeConnexion("localhost",36000);
		 
		 p1.getSocket().envoyereMessage(p1.getPos());
		 
		 
		 
		 
		 // Test saisie touche au clavier
		 
		 
		 
	 }



	public int[][] getMatrice_jeu() {
		return matrice_jeu;
	}



	public void setMatrice_jeu(int[][] matrice_jeu) {
		this.matrice_jeu = matrice_jeu;
	}



	public PositionJoueur getPos() {
		return pos;
	}



	public void setPos(PositionJoueur pos) {
		this.pos = pos;
	}


}
