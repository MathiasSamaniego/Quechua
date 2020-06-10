package RequetesBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Crud_Controller {
	
	private ArrayList<String> list = new ArrayList<String>();

	public Crud_Controller() throws ClassNotFoundException{
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("k");
		list.add("l");
		list.add("m");
		list.add("n");
		list.add("o");
		list.add("p");
		list.add("q");
		list.add("r");
		list.add("s");
		list.add("t");
		list.add("u");
		list.add("v");
		list.add("w");
		list.add("y");
		list.add("ñ");
	}
	
	/////Test de l'existe de la racien
	public boolean racineExiste(String motracine) throws ClassNotFoundException, SQLException {
		boolean racine = false;
		boolean b = false;
		char s = motracine.charAt(0);
		String s1 = String.valueOf(s);
		
		
		/////Test pour savoir sil existe un motracine racine commencant par la lettre s1
		for(int i = 0; i < list.size(); i++) {
			if(s1.equals(list.get(i))) {
				System.out.println("Il y a des racines commençant par cette lettre!");
				b = true;
				break;
			}
			else {
				if(i == list.size()-1 && !s1.equals(list.get(i))) {
					System.out.println("Erreur aucune racine commençant par cette lettre");
					racine = false;
					return racine;
				}
				else {
					System.out.println("On passe au motracine suivant");
				}
			}
		}
		
		
		
		if(b) {/////S'il existe des motracine racine commencant par s1
			
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:C:\\Users\\alain\\OneDrive\\Documents/CorrectorQuechua.db";
			Connection c = null;
			c = DriverManager.getConnection(url);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT motracine FROM " + s1);
			String racineSaisiACorriger = "";
			
			while(rs.next()) {
				String racineATrouverDansTable = rs.getString(1);
				int longueur = racineATrouverDansTable.length();
				
				for(int i = 0; i < longueur; i++) {
					racineSaisiACorriger = racineSaisiACorriger + motracine.charAt(i);
				}
				
				if(racineSaisiACorriger.contentEquals(racineATrouverDansTable)) {
					racine = true;
					return racine;
				}
				else {
					racineSaisiACorriger = "";
				}
			}
		}
		
		
		return racine;
	}

	public boolean suffixeExist() {
		return false;
		
	}
}
