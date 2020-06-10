package LireFichiers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemplirSuffixe {
	
	
	public void RemplirSuffixes(String cheminFichier,String table) throws IOException, ClassNotFoundException, SQLException {
		String chaine="";
		int i = 0;
		int j = 0;
		int nombredelignesTotales = 0;
	      //lecture du fichier texte
	         InputStream ips = new FileInputStream(cheminFichier);
	         InputStreamReader in = new InputStreamReader(ips);
	         BufferedReader br = new BufferedReader(in);
	         String ligne;
	         while ((ligne = br.readLine()) != null){
	            chaine = "";
	            nombredelignesTotales++;
	            
	            if((ligne.charAt(0)) == '#') {
	            } else { 
	            	i = 0;
	            	j = 0;
	            	while(ligne.charAt(i) != '/') {
            			chaine = chaine + ligne.charAt(j);
	            		i++;
	            		j = i;
	            	}
	            	j++;
	            		System.out.println(chaine);
	            		Class.forName("org.sqlite.JDBC"); // loaded the driver (use properties)
	            		String url = "jdbc:sqlite:C:\\\\Users\\\\alain\\\\OneDrive\\\\Documents/CorrectorQuechua.db";
	            		//String url = "jdbc:sqlite://127.0.0.1:5432/DataBaseQuechua.db";
	            		Connection c = null;
	            		c = DriverManager.getConnection(url);
	    				Statement s =  c.createStatement();
	    					System.out.println("INSERT INTO "+ table +"(suffixe) VALUES('" + chaine +");");
    						s.executeUpdate("INSERT INTO " + table +"(suffixe) VALUES('" + chaine + "');");
	            }
	         }
	         System.out.println("Lignes totales : " + nombredelignesTotales);
	         br.close();
	      }

	

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		RemplirSuffixe suffixe = new RemplirSuffixe();
		suffixe.RemplirSuffixes("ressources/dictionnaire/Sufijos Adjectivaux  QU.txt","Suffixes_Adjectivaux");
		suffixe.RemplirSuffixes("ressources/dictionnaire/Sufijos Adverbiaux  QU.txt","Suffixes_Averbiaux");
		suffixe.RemplirSuffixes("ressources/dictionnaire/Sufijos Nominaux  QU.txt","Suffixes_Nominaux");
		suffixe.RemplirSuffixes("ressources/dictionnaire/Sufijos pos_posés SPP.txt","Suffixes_PosPoses");
		suffixe.RemplirSuffixes("ressources/dictionnaire/Sufijos Pronominaux  QU.txt","Suffixes_Pronomiaux");
		suffixe.RemplirSuffixes("ressources/dictionnaire/Sufijos Verbaux inter-position QU.txt","Suffixes_VerbauxInterPosition");

	}
}
