package joueur;


/**
 * Represente la partie d'un serpent
 * @author etudiant
 *
 */
public class SnakePart {
	
	
	private int posX;
	private int posY;
	
	private int dimX;
	private int dimY;
	
	private SnakePart PrecedPart;
	
	/**
	 * 
	 * @param x : position en x
	 * @param y : position en y
	 * @param dimx : longeur en X
	 * @param dimy : largeur en Y
	 */
	public SnakePart(int x, int y,int dimx,int dimy){
		posX=x;
		posY=y;
		dimX=dimx;
		dimY=dimy;
		
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

	public int getDimX() {
		return dimX;
	}

	public void setDimX(int dimX) {
		this.dimX = dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public void setDimY(int dimY) {
		this.dimY = dimY;
	}
	
	
	
}
