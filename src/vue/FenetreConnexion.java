package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FenetreConnexion extends JFrame {
	CentralWidget cw;

	
	public FenetreConnexion() {
		
	
		cw= new CentralWidget();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        this.setTitle("Snake RPG Multi Joueur");
        // Taille de la frame
        this.setSize(500, 200);

        this.setResizable(true);
     
        this.setVisible(true);
        
        JLabel zoneNom= new JLabel();
        
        this.add(cw);

	}
	
	
	 public static void main(String[] args) {

	    	
	    	SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    new FenetreConnexion();
	                }
	            });
	        
	    }

}
