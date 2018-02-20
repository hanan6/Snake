package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

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
 
    public FenetrePricipale() {
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
        
        
    }
    
    public void paint(Graphics g) {
        g.fillRect(0,0,200,20);
      
      }
     
    public static void main(String[] args) {
        // construit une fenêtre de type TestKeyListener et l'affiche
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new FenetrePricipale();
                frame.getContentPane().add(new MainClass());
                frame.setVisible(true);
            }
        });
    }
}
