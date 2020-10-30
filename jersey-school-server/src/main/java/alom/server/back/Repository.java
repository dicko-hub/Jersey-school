package alom.server.back;

import java.util.HashMap;
import java.util.Map;


public class Repository {

	private static Map<String,Etudiant> etudiants = new HashMap<String,Etudiant> ();
	
	private static Map<String,Matiere> matieres = new HashMap<String,Matiere> ();
	
	private static Map<String,Groupe> groupes = new HashMap<String,Groupe>();
	
	
	private static final Repository INSTANCE = new Repository();
	
	private  Repository() {
		 
	}
	
	 public static Repository getInstance(){
		 return INSTANCE;
	 }
	
	 public Map<String, Etudiant> getEtudiants(){
		 return etudiants;
	 }
	 
	 public Map<String, Matiere> getMatieres(){
		 return matieres;
	 }
	 
	 public Map<String, Groupe> getGroupes(){
		 return groupes;
	 }
	
}
