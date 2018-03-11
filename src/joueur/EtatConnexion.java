package joueur;

import joueur.PositionJoueur;

/**
 * Geston de l'etat de connexion du joueur
 * @author etudiant
 *
 */

public interface EtatConnexion {
	
	/**
	 *  Envoie la position actueclle du joeur au server
	 * @param pos: postion du joeur;
	 */
	public void updatePosition(String texte); 
	
	
	/**
	 *  demande de connexion Client
	 */
	public void playerConnection();
	
	
	/**
	 * demande de deconnexion de la part du Client
	 */
	
	public void playerDisconnection();
	
	
	/**
	 * Affichage de l'etat de la connexion
	 */
	
	public void print();
}
