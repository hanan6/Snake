package client_server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import vue.DrawPanel;

import joueur.Deplacement;
import joueur.DeplacementBas;
import joueur.DeplacementDroite;
import joueur.DeplacementGauche;
import joueur.DeplacementHaut;
import joueur.Player;


/**
* Implémente l'interface KeyListener (écouteur d'événements clavier) : 
* lorsqu'une touche est appuyée ou relâchée, affiche le code de touche
* correspondant dans un objet JLabel qui doit être fourni au constructeur.
*/


public class KeyCommand implements KeyListener {
   private final  DrawPanel label;
   
   private static final int D_W = 200;
   private static final int D_H = 200;
   int x = 0;
   int y = 0;
   
   boolean ok= false;
   
   int sens= 0; // droite
   
   int c=0; 
  
   private Player p;// ajout d'un joueur;
   
   Deplacement deplacement; //= new DeplacementDroite(this);
   
   DeplacementBas depBas;
   
   DeplacementHaut depHaut;
   
   DeplacementDroite depDroit;
   
   DeplacementGauche depGauche;
   
   
   /* Ajout dun joueur et test de connexion */
   
    
   public KeyCommand( DrawPanel panel_) throws UnknownHostException, IOException {
      label = panel_;
      p = new Player(label.getId_player(),label.getPwd_player(),label.getSnake(),"localhost",36000);
      depBas= new  DeplacementBas(this );
      depHaut= new  DeplacementHaut(this );
      depDroit= new  DeplacementDroite(this );
      depGauche= new DeplacementGauche(this);
       
      deplacement= depBas;
       
       //p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()); // connecxion au serveur
       //p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
       
       ActionListener listener = new AbstractAction() {
           public void actionPerformed(ActionEvent e) {

        	 //deplacement();
        	   
        	  deplacement.seDeplacer();
        	  
        	  
        	
           }
       };
       Timer timer = new Timer(500, listener);
       timer.start();
       
       
   }

   /**
    * Gestion de l'evenement de saisie de touche clavier
    */
   public void keyPressed(KeyEvent e) {
		   System.out.println(e.getKeyCode()==KeyEvent.VK_UP);	 
		   if (e.getKeyCode()==KeyEvent.VK_UP){
			  
			   deplacement=depHaut;

		   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_DOWN){
  
			   deplacement=depBas;

			   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_LEFT){
				  
			   deplacement= depGauche;
			   }
		   if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				  deplacement= depDroit;
				 
			   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_A){

			   p.getEtatconnexion().playerConnection();

			}

   }

   public void keyReleased(KeyEvent e) {
   
   }

   public void keyTyped(KeyEvent e) {
       // on ne fait rien
   }
   
  

	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getC() {
		return c;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	public Player getP() {
		return p;
	}
	
	public void setP(Player p) {
		this.p = p;
	}
	
	public static int getdW() {
		return D_W;
	}
	
	public static int getdH() {
		return D_H;
	}
	
	public DrawPanel getLabel() {
		return label;
	}
}