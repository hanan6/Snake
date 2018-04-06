package client_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe de Connexion avec la base 
 * @author etudiant
 *
 */

public class DataBase {
	
	public DataBase(){
		
	}
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();
    
    int idUtilisateur;// = resultat.getInt( "id" );
    String emailUtilisateur;// = resultat.getString( "email" );
    String motDePasseUtilisateur; // = "";//resultat.getString( "mot_de_passe" );
    String nomUtilisateur; // = resultat.getString( "nom" );
    
    public boolean executerTests(String idPlayer, String mdpPlayer) {
    	
    	
    	boolean test=false;
        /* Chargement du driver JDBC pour MySQL/PostGreSQL */
        try {
           // messages.add( "Chargement du driver..." ); 	
        	System.out.println("Chargement du driver...");
            Class.forName( "org.postgresql.Driver" );
            System.out.println("Driver chargé !");// messages.add( "Driver chargé !" );
        } catch ( ClassNotFoundException e ) {
           
            
            System.out.println("Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage() );
        }
        

        /* Connexion à la base de données */
        String url = "jdbc:postgresql://localhost:5432/testbd";
        String utilisateur = "tintin";
    	String motDePasse = "milou";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
          //  messages.add( "Connexion à la base de données..." );
            System.out.println( "Connexion à la base de données...");
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
          //  messages.add( "Connexion réussie !" );
            System.out.println( "Connexion réussie !");
            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
           // messages.add( "Objet requête créé !" );
            System.out.println( "Objet requête créé !");
            /* Exécution d'une requête de lecture */
            
            
            resultat = statement.executeQuery( "SELECT id, email, nom FROM Utilisateur where id="+idPlayer+" and mot_de_passe='"+mdpPlayer+"';");
        
           
            //Récupération des données du résultat de la requête de lecture 
            
            
          ///  System.out.println("Lancement de la requette");
            int i=0;
            while ( resultat.next() ) {
                int idUtilisateur = resultat.getInt( "id" );
                String emailUtilisateur = resultat.getString( "email" );
                String motDePasseUtilisateur = "";//resultat.getString( "mot_de_passe" );
                String nomUtilisateur = resultat.getString( "nom" );
                ///Formatage des données pour affichage dans la JSP finale.
                messages.add( "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
                        + ", motdepasse = "
                        + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );
                i++;
            } 
            
            System.out.println("nb de resulats="+i);
            
            if (i>0){
            	test=true;
            }
            
            
        } catch ( SQLException e ) {
         /*   messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );*/
                   
            
            System.out.println("Erreur lors de la connexion : <br/>"
                    + e.getMessage());
        } finally {
            messages.add( "Fermeture de l'objet ResultSet." );
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Statement." );
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Connection." );
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }

        return test;  //messages;
    }
    

	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
    
}