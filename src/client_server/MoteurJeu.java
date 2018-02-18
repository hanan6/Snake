package client_server;

import java.util.ArrayList;

import joueur.Miams;
import joueur.Monstre;
import joueur.Player;


/**
 * Cette classe reprensente une partie de jeu et composée des differntes propriétes suivantes:
 * @attribute joueur: ensemble des joueurs connectée à la Partie
 * @attribute montres: ensemble de Monstre
 * @attribute miam: ensemble de Miam
 * @attribute server: 
 * 
 * @author etudiant
 *
 */
public class MoteurJeu {
	
	 
	ArrayList<Miams> miams;
	ArrayList<Monstre> montres;
	ArrayList<Player> players;
	
	MultiThreadSocketServer server;
	SocketClient sock_client;
	
	int[][] matrice_jeu= new int[10][5];
	
	
	public MoteurJeu(){
		
	}
	
	public MultiThreadSocketServer getServer() {
		return server;
	}

	public void setServer(MultiThreadSocketServer server) {
		this.server = server;
	}

	public SocketClient getSock_client() {
		return sock_client;
	}

	public void setSock_client(SocketClient sock_client) {
		this.sock_client = sock_client;
	}

	public int[][] getMatrice_jeu() {
		return matrice_jeu;
	}

	public void setMatrice_jeu(int[][] matrice_jeu) {
		this.matrice_jeu = matrice_jeu;
	}


	
	/* Getters et Setters */
	
	public ArrayList<Miams> getMiams() {
		return miams;
	}

	public void setMiams(ArrayList<Miams> miams) {
		this.miams = miams;
	}

	public ArrayList<Monstre> getMontres() {
		return montres;
	}

	public void setMontres(ArrayList<Monstre> montres) {
		this.montres = montres;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	/*  Essai de connexion d'un client*/
	
	
	

}
