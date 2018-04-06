package joueur;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
	
	String password;
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	int vie;
	private int niveau;
	Snake  snakeJoueur;
	SocketClient socket;
	
	int[][] matrice_jeu= new int[10][5];
	
	private  PositionJoueur pos;
    EtatConnexion etatconnected; // etat de la connexion du joeur;
    EtatConnexion etatdisconnected;
    EtatConnexion etatconnexion;
	

	
	

	public Player(String id_joueur,String password, Snake sk, String serverAdress, int port) throws UnknownHostException, IOException{
		pos= new PositionJoueur(); // Initilisation de la position du joeur
		id="12";
		snakeJoueur=sk;
		
		etatconnected= new EtatConnected(this);
		etatdisconnected= new EtatDisconnected(this);
		etatconnexion= etatdisconnected;
		
		socket= new SocketClient(serverAdress,port,this);
		id=id_joueur;
		
		this.password=password;
	}


	
	/* --------------------------- getters and Setters---------------*/
	
	public Snake getSnakeJoueur() {
		return snakeJoueur;
	}



	public void setSnakeJoueur(Snake snakeJoueur) {
		this.snakeJoueur = snakeJoueur;
	}



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
	
	public void demandeConnexion(String message){
		
		// socket= new SocketClient();
		 
		
		 
		 
		 socket.connexion(message);
		 //socket.envoyereMessage("Pos:X="+pos.getPosX()+"Y="+pos.getPosY());
		
		
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



	public EtatConnexion getEtatconnected() {
		return etatconnected;
	}


	public EtatConnexion getEtatdisconnected() {
		return etatdisconnected;
	}


	public EtatConnexion getEtatconnexion() {
		return etatconnexion;
	}


	public void setEtatconnexion(EtatConnexion etatconnexion) {
		this.etatconnexion = etatconnexion;
	}


}
