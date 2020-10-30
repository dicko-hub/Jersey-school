package alom.server.back;

import java.util.ArrayList;

public class MatieresList {
	
	private ArrayList<Matiere> matieres;

	
	public MatieresList() {
		
	}


	public MatieresList(ArrayList<Matiere> matieres) {
		
		this.matieres = matieres;
	}


	public ArrayList<Matiere> getMatieres() {
		return matieres;
	}


	public void setMatieres(ArrayList<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	

}
