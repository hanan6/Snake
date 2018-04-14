package vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class CentralWidget extends JPanel  {
	
	
	private JPanel grandPanel;
	private JPanel zoneGauche;
	private JPanel zoneDroit;
	
	private JPanel zoneDroitHaut;
	private JPanel zoneDroitBas;
	
	private  JTextArea zonesaisie;
	
	private JEditorPane affichageDroitHaut;
	private JEditorPane affichageDroitBas;
	
	private JButton btnGo;

	String text;
	
	JTextField textField,textField_1; 
	JLabel lblPhone;
	
	public CentralWidget(){
		
		 btnGo= new JButton("Connexion au Jeu");
		 grandPanel= new JPanel(new GridLayout(1, 2));
		
		grandPanel.setBackground(new Color(2));
		
		zoneGauche= new JPanel();
		textField = new JTextField();
		textField.setBounds(128, 28, 86, 20);
		
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Identifiants");
		lblName.setBounds(65, 31, 46, 14);
		zoneGauche.add(lblName);
		zoneGauche.add(textField);
		
		
		lblPhone = new JLabel("Mot de Passe");
		lblPhone.setBounds(65, 68, 46, 14);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 65, 86, 20);
		//frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		zoneGauche.add(lblPhone);
		zoneGauche.add(textField_1);
		
		
		zoneGauche.add(btnGo);

        btnGo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				text=  textField.getText();
				
				
				
				SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                    	FenetrePricipale f=new FenetrePricipale(text, textField_1.getText());
						
						//zoneDroitHaut.add(f.getPanel());
						//zoneDroitHaut.repaint();
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
            });

			}
		});
		
		grandPanel.add(zoneGauche);

			
		setLayout(new BorderLayout());
		add(grandPanel);
		
	}
	
	


}
