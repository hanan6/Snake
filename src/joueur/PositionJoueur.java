package joueur;

import java.io.Serializable;

public class PositionJoueur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6992596171903163751L;
	int posX;
	int posY;
	
	public PositionJoueur(){		
		posX=0;
		posY=0;
	}
	
	/**
	 * Affiche les cordonnées du joueur/snake dans le jeu
	 */
	public void affichagePosition(){
		
		System.out.println("Position joueur: X("+posX+") , Y("+posY+")");
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
		affichagePosition();
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
		affichagePosition();
	}

}
