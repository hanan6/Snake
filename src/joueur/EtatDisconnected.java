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

		player.demandeConnexion(/*"localhost",36000, */"demandeconnexion:"+player.getId());
		if (player.getSocket().getServerResponse().equals("ok")){
			player.setEtatconnexion(player.getEtatconnected());
		}
		
		player.getEtatconnexion().print();
	}

	public void playerDisconnection() {

	}

	public void updatePosition(String texte) {
	/*	Snake sk= player.getSnakeJoueur();
		
		for(int i=0; i<sk.getSetPart().size();i++){
			SnakePart sk_i= player.getSnakeJoueur().getSetPart().get(i);
			player.demandeConnexion("localhost",36000, "Pos:X="+sk_i.getPosX()+"Y="+sk_i.getPosY());
			
		}*/
	}
	
	public void print() {
		System.out.println("Etact actuel :deconnecté");
	}

	

}
