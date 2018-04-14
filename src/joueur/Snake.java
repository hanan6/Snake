package joueur;

import java.util.ArrayList;

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
	
	ArrayList<SnakePart> setPart= new ArrayList<SnakePart>();
	

	/**
	 * Creation
	 */
	public Snake( ){
		/* Initialisation à definir */
	//	setPart.add(head); // ajout de la tete du serpent
		
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

	
	/**
	 * ajout de partie du Snake ( agrandissment de la taille)
	 */
	public void addPart(SnakePart p){
		int n=setPart.size();
		if(n>0){
			p.setPosX(setPart.get(n-1).getPosX()-20);
			p.setPosY(setPart.get(n-1).getPosY());
		}
		setPart.add(p);	
	}
	
	
	/**
	 * suppression d'une partie du Snake ( reduction de la taille)
	 */
	public void removePart(int n){
		int snake_size= setPart.size();
		
		if (snake_size>1){
				setPart.remove(snake_size-1);
		}
	}	
	
	
	/**
	 * Mise à jour des position (moouvement vers le bas)
	 */
	public void moveDown(){
		
		int pos_y;
		pos_y=setPart.get(0).getPosY();
		int dim=setPart.get(0).getDimX();
		setPart.get(0).setPosY(pos_y+dim);
		if (setPart.size()>1){
			for(int i=1;i<setPart.size();i++){
				setPart.get(i).setPosY(pos_y);
				pos_y=setPart.get(i).getPosY();
			}
		}
	}
	
	/**
	 * Mise à jour des position (moouvement vers le haut)
	 */
	public void moveTop(){
		// modification de la position de la tete
		int pos_y;
		pos_y=setPart.get(0).getPosY();
		int dim=setPart.get(0).getDimX();
		setPart.get(0).setPosY(pos_y-dim);
		if (setPart.size()>1){
			for(int i=1;i<setPart.size();i++){
				setPart.get(i).setPosY(pos_y);
				pos_y=setPart.get(i).getPosY();
			}
		}
	}
	
	/**
	 * Mise à jour des position (moouvement vers la gauche)
	 */
	public void moveLelft(){
		// modification de la position de la tete
		int pos_x;
		pos_x=setPart.get(0).getPosX();
		int dim=setPart.get(0).getDimX();
		setPart.get(0).setPosX(pos_x-dim);
		if (setPart.size()>1){
			for(int i=1;i<setPart.size();i++){
				setPart.get(i).setPosX(pos_x);
				pos_x=setPart.get(i).getPosX();
			}
		}
	}
	
	/**
	 * Mise à jour des position (moouvement vers la la droute)
	 */
	public void moveLeft(){
		// modification de la position de la tete
		int pos_x;
		pos_x=setPart.get(0).getPosX();
		int dim=setPart.get(0).getDimX();
		setPart.get(0).setPosX(pos_x+dim);
		if (setPart.size()>1){
			for(int i=1;i<setPart.size();i++){
				setPart.get(i).setPosX(pos_x);
				pos_x=setPart.get(i).getPosX();
			}
		}
	}
	
	/**
	 * Mise à jour de position des differentes parties
	 */
	public void moving(){

		int pos_x, pos_y, pos_x1, pos_y1;
		pos_x=setPart.get(0).getPosX();
		pos_y=setPart.get(0).getPosY();
		if (setPart.size()>1){
			for(int i=1;i<setPart.size();i++){

				pos_x1=setPart.get(i).getPosX();
				pos_y1=setPart.get(i).getPosY();
				setPart.get(i).setPosY(pos_y);
				setPart.get(i).setPosX(pos_x);
				pos_x=pos_x1;
				pos_y=pos_y1; 
			}
		}
		
	}

	public ArrayList<SnakePart> getSetPart() {
		return setPart;
	}

	public void setSetPart(ArrayList<SnakePart> setPart) {
		this.setPart = setPart;
	}

	
	public void addPartFixed(SnakePart sp){
		
		setPart.add(sp);
	}


}
