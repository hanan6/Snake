package controleur;

import java.util.ArrayList;

import model.Miams;
import model.Monstre;
import model.Player;

/**
 * Cette classe reprensente une partie de jeu et composée des differntes propriétes suivantes:
 * @attribute joueur: ensemble des joueurs connectée à la Partie
 * @attribute montres: ensemble de Monstre
 * @attribute miam: ensemble de Miam
 * 
 * @author etudiant
 *
 */
public class MoteurJeu {
	 
	ArrayList<Miams> miams;
	ArrayList<Monstre> montres;
	ArrayList<Player> players;
	
	public MoteurJeu(){
		
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
	

}
