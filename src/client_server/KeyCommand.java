package client_server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
  
   private Player p= new Player(); // ajout d'un joueur;
   
   Deplacement deplacement; //= new DeplacementDroite(this);
   
   DeplacementBas depBas;
   
   DeplacementHaut depHaut;
   
   DeplacementDroite depDroit;
   
   DeplacementGauche depGauche;
   
   
   /* Ajout dun joueur et test de connexion */
   
    
   public KeyCommand( DrawPanel panel_) {
      label = panel_;
      depBas= new  DeplacementBas(this );
      depHaut= new  DeplacementHaut(this );
      depDroit= new  DeplacementDroite(this );
      depGauche= new DeplacementGauche(this);
       
      deplacement= depHaut;
       
       //p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()); // connecxion au serveur
       p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
       
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
			//  p.getPos().setPosY(p.getPos().getPosY()+1);
			//  p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
		   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_DOWN){
				  
			//	  p.getPos().setPosY(p.getPos().getPosY()-1);
			//	  p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
				  
			   deplacement=depBas;
				  //ok=true;
				 // sens=1;
                  
			   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_LEFT){
				  
			//	  p.getPos().setPosX(p.getPos().getPosX()-1);
			//	  p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
			   deplacement= depGauche;
			   }
		   if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				  
			//	  p.getPos().setPosX(p.getPos().getPosX()+1);
			//	  p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
				  
				//  ok=true;
				  deplacement= depDroit;
				 // sens=0;
			   }
		   
		   if (e.getKeyCode()==KeyEvent.VK_A){
				  
				//p.demandeConnexion("localhost",36000, "demandeconnexion");
			   p.getEtatconnexion().playerConnection();

				   }

   }

   public void keyReleased(KeyEvent e) {
   
   }

   public void keyTyped(KeyEvent e) {
       // on ne fait rien
   }
   
   /*
    * Fonction de gestion du sens de deplacement du Snake
    */
   
   public void deplacement(){
	   // si le sens est egal à 0
	   
  	 if (sens==0){
  	  
      	  if (ok==false){
	               if (c >= D_W) {
	                   c = 0;
	                   label.getSnake().moving();
	                   label.getSnake().getSetPart().get(0).setPosX(c);
	                   label.repaint();
	                   
	                   p.getPos().setPosX(0);
	                  // p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
	                  // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
	                   p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
	                   
	
	               } else {
	                   c +=20;
	                  
	                   label.getSnake().moving();
	                   label.getSnake().getSetPart().get(0).setPosX(c);         
	                   label.repaint();
	                   
	                   p.getPos().setPosX(p.getPos().getPosX()+1);
	                   //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
	                  // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
	                   p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
	
	               }
	               
	               
	           }
      	  else{
      		  if (c >/*=*/ D_W) {
	                   c = 0;
	                   y=y+20;
	                   label.getSnake().moving();
	                   label.getSnake().getSetPart().get(0).setPosY(y);
	                   label.getSnake().getSetPart().get(0).setPosX(c);
	               
	
	               }
      		  else {

	                   label.getSnake().moving();
	                   y=y+20;
	                   label.getSnake().getSetPart().get(0).setPosY(y);
	                   label.getSnake().getSetPart().get(0).setPosX(c);
	                   label.repaint();
	                   
	                   p.getPos().setPosY(p.getPos().getPosY()+1);
	       			   //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
	                   //p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
	                   p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());

	               }
      		  
      		  ok=false;
      		  // changement de sens
      		  sens=1;
      		  
      		  
      	  }
  	  
     } // fin sens 0
  	 
     if(sens==1){
  	   
  	   if (ok==false){
             if (y >= D_H) {
                 y = 0;
                 label.getSnake().moving();
                 label.getSnake().getSetPart().get(0).setPosY(y);
                 label.repaint();
                 
                 p.getPos().setPosY(0);
     			 //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
                // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
                 p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());

             } else {	                   
                 y +=20;

                 label.getSnake().moving();
                 label.getSnake().getSetPart().get(0).setPosY(y);         
                 label.repaint();
                 
                 p.getPos().setPosY(p.getPos().getPosY()+1);
                // p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
                 //p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
                 p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());

             }
             
             
         }
  	  else{
  		  if (c >= D_W) {
                 c = 0;
                // c=c+20;
                 label.getSnake().getSetPart().get(0).setPosY(y);
                 label.getSnake().getSetPart().get(0).setPosX(c);
                 
                 p.getPos().setPosX(0);
                 //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
                 p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
             

             } else {
                 
                 label.getSnake().moving();
                 c=c+20;
                 label.getSnake().getSetPart().get(0).setPosY(y);
                 label.getSnake().getSetPart().get(0).setPosX(c);
                 label.repaint();
                 
                 p.getPos().setPosX(p.getPos().getPosX()+1);
                 //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
                // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
                 p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
                
               	
             }
  		  
  		  ok=false;
  		  // changement de sens
  		  sens=0;
  		  
  		  
  	  }
  	   
  	   
     }
	   
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