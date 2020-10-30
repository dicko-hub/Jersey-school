package alom.client.back;

import java.util.ArrayList;

public class EtudiantsList {
	
	private ArrayList<Etudiant> etudiants;

	
	public EtudiantsList() {
		
	}


	public EtudiantsList(ArrayList<Etudiant> etudiants) {
		
		this.etudiants = etudiants;
	}


	public ArrayList<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(ArrayList<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	

}
