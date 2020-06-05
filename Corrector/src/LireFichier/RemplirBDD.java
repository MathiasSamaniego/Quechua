package LireFichier;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RemplirBDD {


	private int nombredelignesTotales = 0;
	private int nombredelignes = 0;
	private ArrayList<String> list = new ArrayList<String>();


	// lecture du fichier texte
	public void RemplirRacine(String string) throws IOException, ClassNotFoundException, SQLException {
		String chaine = "";
		String type = "";
		int i = 0;
		int j = 0;
		int k = 0;
		InputStream ips = new FileInputStream("src/LireFichier/Dictionary  générale FR_QU pour Soni_syllabes.txt");
		InputStreamReader in = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(in);
		String ligne;
		while ((ligne = br.readLine()) != null) {
			chaine = "";
			nombredelignesTotales++;

			if ((ligne.charAt(0)) == '#') {
			} else {
				i = 0;
				j = 0;
				k = 0;
				while (ligne.charAt(i) != '"') {
					i++;
					j = i;
				}
				j++;
				if (ligne.charAt(j) == string.charAt(0)) {
					nombredelignes++;
					while (ligne.charAt(j) != '"') {
						if (ligne.charAt(j) == '(')
							break;
						chaine = chaine + ligne.charAt(j);
						j++;
					}

					while (ligne.charAt(k) != ',') {
						k++;
					}
					k++;
					type = "";
					while (ligne.charAt(k) != '+') {
						if (ligne.charAt(k) == ',') {
							type = "";
							k++;
						}
						type = type + ligne.charAt(k);
						k++;
					}
					System.out.println(chaine + "     " + type);

					Class.forName("org.sqlite.JDBC"); // loaded the driver (use properties)
					String url = "jdbc:sqlite:C:\\Users\\alain\\OneDrive\\Documents/CorrectorQuechua.db";
					// String url = "jdbc:sqlite://127.0.0.1:5432/DataBaseQuechua.db"; Connection
					Connection c = null;
					c = DriverManager.getConnection(url);
					Statement s = c.createStatement();
					ResultSet st = s.executeQuery("SELECT * FROM " + string + " ;");
					boolean b = false;
					while (st.next()) {
						if (st.getString(2).equals(chaine) && st.getString(3).equals(type)) {
							b = true;
						}
					}
					if (b == false) {
						System.out.println(
								"INSERT INTO " + string + " (mot, type) VALUES('" + chaine + "','" + type + "');");
						if (type.equals("MWE")) {
							s.executeUpdate("INSERT INTO " + string + " (mot, type) VALUES('" + chaine + "','MC');");
						} else {
							s.executeUpdate(
									"INSERT INTO " + string + " (mot, type) VALUES('" + chaine + "','" + type + "');");
						}
					}

				}
			}
		}
		System.out.println("///////////////");
		System.out.println("Lignes totales : " + nombredelignesTotales);
		System.out.println("Lignes pour la lettre " + string  +": " + nombredelignes);
		System.out.println("///////////////");
		br.close();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		RemplirBDD remplirbdd = new RemplirBDD();
		remplirbdd.list.add("a");
		remplirbdd.list.add("b");
		remplirbdd.list.add("c");
		remplirbdd.list.add("d");
		remplirbdd.list.add("e");
		remplirbdd.list.add("f");
		remplirbdd.list.add("h");
		remplirbdd.list.add("i");
		remplirbdd.list.add("j");
		remplirbdd.list.add("k");
		remplirbdd.list.add("l");
		remplirbdd.list.add("m");
		remplirbdd.list.add("n");
		remplirbdd.list.add("o");
		remplirbdd.list.add("p");
		remplirbdd.list.add("q");
		remplirbdd.list.add("r");
		remplirbdd.list.add("s");
		remplirbdd.list.add("t");
		remplirbdd.list.add("u");
		remplirbdd.list.add("v");
		remplirbdd.list.add("w");
		remplirbdd.list.add("y");
		remplirbdd.list.add("ñ");
		
		for(int i = 0; i< remplirbdd.list.size(); i++) {
			remplirbdd.RemplirRacine(remplirbdd.list.get(i));
		}

	}
	
	

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}
