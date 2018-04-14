package joueur;

import joueur.PositionJoueur;

/**
 *  Gestion des comportements quand le client est deconnecté
 * @author etudiant
 *
 */

public class EtatDisconnected implements EtatConnexion {

	Player player;
	
	public EtatDisconnected(Player player){
		this.player=player;
	}

	public void playerConnection() {

		player.demandeConnexion("demandeconnexion:"+player.getId()+":"+player.getPassword());
		if (player.getSocket().getServerResponse().equals("okconnexion")){
			player.setEtatconnexion(player.getEtatconnected());
		}

	}

	public void playerDisconnection() {

	}

	public void updatePosition(String texte) {

	}
	
	public void print() {
		System.out.println("Etact actuel :deconnecté");
	}

	

}
