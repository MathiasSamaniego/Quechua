package Correcteur;

import java.sql.SQLException;

import RequetesBdd.Crud_Controller;

public class Algo {
	private String PhraseACorriger;
	private Crud_Controller controller;
	
	
	public Algo() throws ClassNotFoundException {
		controller = new Crud_Controller();

	}
	
	/////Algorithme principal
	public void Correction(String s) throws ClassNotFoundException, SQLException {
		/////Recherche de la racine
			@SuppressWarnings("unused")
			boolean b = this.controller.racineExiste(s);
	}
	
	public String getPhraseACorriger() {
		return PhraseACorriger;
	}

	public void setPhraseACorriger(String PhraseACorriger) {
		this.PhraseACorriger = PhraseACorriger;
	}

	public Crud_Controller getController() {
		return controller;
	}

	public void setController(Crud_Controller controller) {
		this.controller = controller;
	}
}
