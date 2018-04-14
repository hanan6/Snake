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
	
	int nb_point_joeur;
	
	public DataBase(){
		
	}
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();
    
    int idUtilisateur;// = resultat.getInt( "id" );
    String emailUtilisateur;// = resultat.getString( "email" );
    String motDePasseUtilisateur; // = "";//resultat.getString( "mot_de_passe" );
    String nomUtilisateur; // = resultat.getString( "nom" );
    
    
    /**
     * Verification des données saisies par l'utilisateur
     * @param idPlayer
     * @param mdpPlayer
     * @return
     */
    public boolean verificationPlayerId(String idPlayer, String mdpPlayer) {
    	
    	
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
            
            
            resultat = statement.executeQuery( "SELECT id, email, nbre_points, nom FROM Utilisateur where id="+idPlayer+" and mot_de_passe='"+mdpPlayer+"';");
        
           
            //Récupération des données du résultat de la requête de lecture 
            int i=0;
            while ( resultat.next() ) {
                int idUtilisateur = resultat.getInt( "id" );
                String emailUtilisateur = resultat.getString( "email" );
                String motDePasseUtilisateur = "";//resultat.getString( "mot_de_passe" );
                String nomUtilisateur = resultat.getString( "nom" );
                nb_point_joeur= resultat.getInt("nbre_points");
                
            
                i++;
            } 
            
            System.out.println("nb de resulats="+i);
            
            if (i>0){
            	test=true;
            }
            
            
        } catch ( SQLException e ) {  
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
    
    

    
	/**
     * Mise à jour du nombre de points du joueur dans la base de données
     */
    public void  majNbrePoints(int nbPoints){
    	
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
           
            resultat = statement.executeQuery( "SELECT id, email, nom FROM Utilisateur;");
            
            statement.executeUpdate("UPDATE utilisateur SET nbre_points = "+nbPoints+";");
        

            
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
    	
    	
    	
    }
    
    
    

	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
    public int getNb_point_joeur() {
		return nb_point_joeur;
	}


	public void setNb_point_joeur(int nb_point_joeur) {
		this.nb_point_joeur = nb_point_joeur;
	}
	
    
}