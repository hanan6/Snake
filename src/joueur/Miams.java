package joueur;

/**
 * "Miams" correspont à la nourriture que le Snake à possibilité de manger, defini par 
 * les propritées suivantes:
 *  @attribute posX: posotion en X;
 *  @attribute posY: position en Y
 */
public class Miams {
	int posX;
	int posY;
	
	public Miams(int x,int y){
		posX=x;
		posY=y;
		
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

}
