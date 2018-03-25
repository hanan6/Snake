package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import joueur.Snake;
import joueur.SnakePart;

import client_server.KeyCommand;



/**
 * 
 * Fenetre Principale d'utilisation du jeu Snake RPG
 * @author etudiant 
 *
 */


public class FenetrePricipale extends JFrame {
    private static final long serialVersionUID = -5222658361778310082L;
    private BorderLayout layout;
 
    /*public FenetrePricipale() {
        // création de la fenêtre
        super("TestKeyListener");
         
        // ajout d'un seul composant dans cette fenêtre : un JLabel
        JLabel label = new JLabel("Pressez une touche...");
        add(label, BorderLayout.CENTER);
         
        // ajoute un écouteur d'événements personnalisé à la fenêtre
        this.addKeyListener(new KeyCommand(label));
         
        // réglage des dimensions de la fenêtre
        setPreferredSize(new Dimension(300, 100));
        pack();
        
        
        this.setLayout(layout);
		this.setTitle("Snake RPG Multi Joueur");
	    // Taille de la frame
	    this.setSize(1024, 768);
	    // Placer au centre de l'ecran
	    this.setLocationRelativeTo(null);
	    // Resizable ou non
	    this.setResizable(true);
        // Action a la fermeture (croix)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setVisible(true);
        
        
    }*/
    
    private static final int D_W = 500;
    private static final int D_H = 200;
    int x = 0;
    int y = 0;
    SnakePart sp=	new SnakePart(0,0,20,20);
    SnakePart sp2= new SnakePart(0,0,20,20);
    SnakePart sp3= new SnakePart(0,0,20,20);
    Snake monsnake= new Snake( sp);
  
    
    
    DrawPanel drawPanel = new DrawPanel(monsnake);
   // DrawPanel drawPanel2 = new DrawPanel(Color.BLACK,x,y, 10,20);
    
    public FenetrePricipale() {
    	 monsnake.addPart(sp2);
    	 monsnake.addPart(sp3);
    	// ajout d'un seul composant dans cette fenêtre : un JLabel
        JLabel label = new JLabel("Pressez une touche...");
        add(label, BorderLayout.CENTER);
         
        // ajoute un écouteur d'événements personnalisé à la fenêtre
       
    	
    	  setPreferredSize(new Dimension(500, 100));
          pack();
     /*   ActionListener listener = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (x >= D_W) {
                    x = 0;
                    drawPanel.setX(x); drawPanel.setY(y);
                    drawPanel.repaint();
                    
                //    drawPanel2.setX(x); drawPanel2.setY(y);
                //    drawPanel2.repaint();
                    
                    
                } else {
                    x += 10;
                    drawPanel.setX(x); drawPanel.setY(y);
                    drawPanel.repaint();
                    
                   // drawPanel2.setX(x); drawPanel2.setY(y);
                   // drawPanel2.repaint();
                }
            }
        };
        Timer timer = new Timer(100, listener);
        timer.start();*/
        
        this.addKeyListener(new KeyCommand(drawPanel));
         
        add(drawPanel);
        //add(drawPanel2);
        pack();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        g.fillRect(0,0,200,20);
        g.dispose();
        
        g.fillRect(15,10,200,30);
      
      }
     
    public static void main(String[] args) {
        // construit une fenêtre de type TestKeyListener et l'affiche
       /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new FenetrePricipale();
                frame.getContentPane().add(new MainClass());
                frame.setVisible(true);
            }
        });*/
    	
    	
    	SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new FenetrePricipale();
                }
            });
        
    }
}
