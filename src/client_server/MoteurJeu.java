package client_server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import joueur.Miams;
import joueur.Monstre;
import joueur.Player;
import joueur.SocketClient;


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
	//ArrayList<Player> players;
	Map<Integer,Integer> players;
	
	MultiThreadSocketServer server;
	SocketClient sock_client;
	
	int[][] matrice_jeu= new int[10][5];
	
	
	public MoteurJeu(){
		players= new HashMap<Integer,Integer>();
		
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

	public Map<Integer, Integer> getPlayers() {
		return players;
	}

	public void setPlayers(Map<Integer, Integer> players) {
		this.players = players;
	}
	
	/*  Essai de connexion d'un client*/
	
	

}
