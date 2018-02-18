package joueur;

/**
 * Classe representant le Snake ayant pour proprieté
 * posX: sa position en X
 * posY: sa position en Y
 * direction: ........
 * @author etudiant
 *
 */
public class Snake {
	
	private int posX; 
	private int posY;
	private int nb_miam;
	private String direction; //( A revoir )
	
	/**
	 * Creation
	 */
	public Snake(){
		/* Initialisation à definir */
		
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNb_miam() {
		return nb_miam;
	}

	public void setNb_miam(int nb_miam) {
		this.nb_miam = nb_miam;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}


}
