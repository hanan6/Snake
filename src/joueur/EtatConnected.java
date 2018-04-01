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
		//player.demandeConnexion("localhost",36000, texte);
		
		player.demandeConnexion(/*"localhost",36000,*/"===================================");
		
		String pos="updpos="+player.getId()+"@P";
		
		
		Snake sk= player.getSnakeJoueur();
		
		if (sk.getSetPart().size()>1){
			for(int i=0; i<sk.getSetPart().size();i++){
				//System.out.print(">>>>>>"+pos+sk.getSetPart().size());
				SnakePart sk_i= player.getSnakeJoueur().getSetPart().get(i);
				//player.demandeConnexion("localhost",36000, "Pos:X="+sk_i.getPosX()+"Y="+sk_i.getPosY());
				pos+=sk_i.getPosX()+","+sk_i.getPosY()+"P";
			}
		}
		
		//System.out.print(">>>>>>"+pos+sk.getSetPart().size());
		player.demandeConnexion(/*"localhost",36000,*/ pos);
		player.demandeConnexion(sk.getSetPart().size()+"===================================");
		
		
		
	}

	public void print() {
		System.out.println("Etact actuel :connecté");
	}

	

	

}
