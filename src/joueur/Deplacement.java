package joueur;

public interface Deplacement {
	
	/*
	 * deplacemnt du Snake
	 */
	public void seDeplacer();
	
	
	public void changementPositionDroit();
	public void changementPositionGauche();
	public void changementPositionHaut();
	public void changementPositionBas();

}
