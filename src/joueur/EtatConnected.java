package joueur;

import joueur.PositionJoueur;

public class EtatConnected implements EtatConnexion {

	Player player;
	
	public EtatConnected(Player player){
		this.player=player;

	}

	public void playerConnection() {

		System.out.println(">Deja connecté");
		player.demandeConnexion("demandedeconnexion:"+player.getId());
		if (player.getSocket().getServerResponse().equals("okdeconnexion")){
			player.setEtatconnexion(player.getEtatdisconnected());
		}
		
	}

	public void playerDisconnection() {
		

	}


	public void updatePosition(String texte) {
		
		String pos="updpos="+player.getId()+"@P";
		Snake sk= player.getSnakeJoueur();
		
		if (sk.getSetPart().size()>1){
			for(int i=0; i<sk.getSetPart().size();i++){
				SnakePart sk_i= player.getSnakeJoueur().getSetPart().get(i);
				pos+=sk_i.getPosX()+","+sk_i.getPosY()+"P";
			}
		}
		
		player.demandeConnexion(pos);
		
	}

	public void print() {
		System.out.println("Etact actuel :connecté");
	}

	

	

}
