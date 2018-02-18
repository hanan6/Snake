package client_server;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import joueur.Player;


/**
* Implémente l'interface KeyListener (écouteur d'événements clavier) : 
* lorsqu'une touche est appuyée ou relâchée, affiche le code de touche
* correspondant dans un objet JLabel qui doit être fourni au constructeur.
*/


public class KeyCommand implements KeyListener {
   private final JLabel label;
   
   private Player p= new Player(); // ajout d'un joueur;
   
   /* Ajout dun joueur et test de connexion */
   
    
   public KeyCommand(JLabel label_) {
       label = label_;
       
       p.demandeConnexion("localhost",36000); // connecxion au serveur
   }

   /**
    * Gestion de l'evenement de saisie de touche clavier
    */
   public void keyPressed(KeyEvent e) {
		   System.out.println(e.getKeyCode()==KeyEvent.VK_UP);	 
		   if (e.getKeyCode()==KeyEvent.VK_UP){
			  
			  p.getPos().setPosY(p.getPos().getPosY()+1);
			  p.getSocket().envoyereMessage(p.getPos());
		   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_DOWN){
				  
				  p.getPos().setPosY(p.getPos().getPosY()-1);
				  p.getSocket().envoyereMessage(p.getPos());
			   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_LEFT){
				  
				  p.getPos().setPosX(p.getPos().getPosX()-1);
				  p.getSocket().envoyereMessage(p.getPos());
			   }
		   if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				  
				  p.getPos().setPosX(p.getPos().getPosX()+1);
				  p.getSocket().envoyereMessage(p.getPos());
			   }

   }

   public void keyReleased(KeyEvent e) {
   
   }

   public void keyTyped(KeyEvent e) {
       // on ne fait rien
   }
}