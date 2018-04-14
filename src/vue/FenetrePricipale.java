package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import joueur.KeyCommand;
import joueur.Snake;
import joueur.SnakePart;




/**
 * 
 * Fenetre Principale d'utilisation du jeu Snake RPG
 * @author etudiant 
 *
 */


public class FenetrePricipale extends JFrame {
    private static final long serialVersionUID = -5222658361778310082L;
    private BorderLayout layout;
    
    private static final int D_W = 500;
    private static final int D_H = 200;
    int x = 0;
    int y = 0;
    /*SnakePart sp=	new SnakePart(0,0,20,20);
    SnakePart sp2= new SnakePart(0,0,20,20);
    SnakePart sp3= new SnakePart(0,0,20,20);
    
    SnakePart sp4= new SnakePart(0,30,20,20);
    SnakePart sp5= new SnakePart(0,0,20,20);*/
    
    SnakePart sp6= new SnakePart(40,0,20,20);
    SnakePart sp7= new SnakePart(0,0,20,20);

    Snake main_snake= new Snake();
  
    ArrayList<Snake> snakes= new ArrayList<Snake> ();
    
    String id_player;
    
    
    DrawPanel drawPanel; 
    
    public FenetrePricipale( String id_player, String pwd_player) throws UnknownHostException, IOException {
    	
    	this.id_player=id_player;
    	drawPanel = new DrawPanel(this.id_player);
    	drawPanel.setPwd_player(pwd_player);
    	/*monsnake.addPart(sp2);
    	monsnake.addPart(sp3);
    	 
    	monsnake2.addPart(sp4);
    	monsnake2.addPart(sp5);
    	 
    	snakes.add(monsnake);
    	snakes.add(monsnake2);*/
    	 
    	//drawPanel.setSnakes(snakes);
    	 
    	main_snake.addPart(sp6);
    	main_snake.addPart(sp7);
    	 
    	drawPanel.setSnake(main_snake);
    	setPreferredSize(new Dimension(500, 300));
        pack();
        
        // ajoute un écouteur d'événements personnalisé à la fenêtre
        this.addKeyListener(new KeyCommand(drawPanel));
         
        add(drawPanel);
        pack();
        
       setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       //this.dispose()
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    public DrawPanel getPanel(){
    	
    	return drawPanel;
    }

     
    public static void main(String[] args) {

    }
}
