package LireFichier;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class RemplirSuffixe {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		String chaine="";
		int i = 0;
		int j = 0;
		int nombredelignesTotales = 0;
		int nombredelignes = 0;
	      //lecture du fichier texte
	      //try{
	         InputStream ips = new FileInputStream("src/LireFichier/Sufijos Adjectivaux QU.txt");
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
	            	while(ligne.charAt(i) != '"') {
	            		i++;
	            		j = i;
	            	}
	            	j++;
		            if(ligne.charAt(j) == 'k') {
	            		nombredelignes++;
	            		while(ligne.charAt(j) != '"') {
		            		if(ligne.charAt(j) == '(') break;
	            			chaine = chaine + ligne.charAt(j);
		            		j++;
		            	}

	            		System.out.println(chaine);
	            	/*	Class.forName("org.sqlite.JDBC"); // loaded the driver (use properties)
	            		String url = "jdbc:sqlite:C:\\Users\\alain\\OneDrive\\Documents/CorrectorQuechua.db";
	            		//String url = "jdbc:sqlite://127.0.0.1:5432/DataBaseQuechua.db";
	            		Connection c = null;
	            		c = DriverManager.getConnection(url);
	    				Statement s = c.createStatement();
	    				ResultSet st = s.executeQuery("SELECT * FROM A;");
	    				boolean b = false;
	    				while(st.next()) {
	    					if(st.getString(2).equals(chaine) && st.getString(3).equals(type)) {
	    						b = true;
	    					}
	    				}
	    				if(b == false) {
	    					System.out.println("INSERT INTO h (mot, type) VALUES('" + chaine + "','" + type + "');");
	    					if(type.equals("MWE")) {	
	    						s.executeUpdate("INSERT INTO h (mot, type) VALUES('" + chaine + "','MC');");
	    					} else {
	    						s.executeUpdate("INSERT INTO h (mot, type) VALUES('" + chaine + "','" + type + "');");
	    					}
	    				}*/
		            }
	            }
	         }
	         System.out.println("Lignes totales : " + nombredelignesTotales);
	         System.out.println("Lignes pour la lettre : " + nombredelignes);
	         br.close();
	      }
}
