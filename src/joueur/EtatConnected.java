package joueur;

import joueur.PositionJoueur;

public class EtatConnected implements EtatConnexion {

	Player player;
	
	public EtatConnected(Player player){
		this.player=player;

	}

	public void playerConnection() {

		System.out.println(">Deja connecté");
		
	}

	public void playerDisconnection() {
		

	}


	public void updatePosition(String texte) {
		player.demandeConnexion("localhost",36000, texte);
		
	}

	public void print() {
		System.out.println("Etact actuel :connecté");
	}

	

	

}
