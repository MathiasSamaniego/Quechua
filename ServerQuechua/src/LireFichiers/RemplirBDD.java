package LireFichiers;

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

	public RemplirBDD() {
		this.list.add("a");
		this.list.add("b");
		this.list.add("c");
		this.list.add("d");
		this.list.add("e");
		this.list.add("f");
		this.list.add("h");
		this.list.add("i");
		this.list.add("j");
		this.list.add("k");
		this.list.add("l");
		this.list.add("m");
		this.list.add("n");
		this.list.add("o");
		this.list.add("p");
		this.list.add("q");
		this.list.add("r");
		this.list.add("s");
		this.list.add("t");
		this.list.add("u");
		this.list.add("v");
		this.list.add("w");
		this.list.add("y");
		this.list.add("ñ");
	}

	// lecture du fichier texte
	public void RemplirRacine(String string) throws IOException, ClassNotFoundException, SQLException {
		String chaine = "";
		String type = "";
		int i = 0;
		int j = 0;
		int k = 0;
		InputStream ips = new FileInputStream("ressources/dictionnaire/Dictionary  générale FR_QU pour Soni_syllabes.txt");
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
					String url = "jdbc:sqlite:C:\\\\Users\\\\alain\\\\OneDrive\\\\Documents/CorrectorQuechua.db";
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
		RemplirBDD remplir = new RemplirBDD();

		
		for(int i = 0; i< remplir.list.size(); i++) {
			remplir.RemplirRacine(remplir.list.get(i));
		}

	}
	
	

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}
