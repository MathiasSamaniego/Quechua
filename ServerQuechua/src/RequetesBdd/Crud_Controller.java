package RequetesBdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Crud_Controller {
	
	
	public Crud_Controller() throws ClassNotFoundException{
	}
	
	
	public ArrayList<String> showCorrection() throws ClassNotFoundException, SQLException {
		ArrayList<String> retour = new ArrayList<String>();
		Class.forName("org.sqlite.JDBC"); // loaded the driver (use properties)
		String url = "jdbc:sqlite:C:\\Users\\mathi\\Documents\\StageQuechua/DataBaseQuechua.db";
		// String url = "jdbc:sqlite://127.0.0.1:5432/DataBaseQuechua.db"; Connection
		Connection c = null;
		c = DriverManager.getConnection(url);
		Statement s = c.createStatement();
		ResultSet st = s.executeQuery("SELECT * FROM  ;");
		return retour;
	}
}
