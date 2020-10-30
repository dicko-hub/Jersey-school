package alom.server.controller;

import java.util.ArrayList;
import java.util.Map;

import alom.server.back.Etudiant;
import alom.server.back.Groupe;
import alom.server.back.GroupesList;
import alom.server.back.Repository;

public class GroupeController {
	
	private static Map<String,Groupe> GroupeRepository = Repository.getInstance().getGroupes();

	
	public GroupesList getGroupes() {
		
		ArrayList<Groupe> groupes = new ArrayList<Groupe>(GroupeRepository.values());
		GroupesList listes = new GroupesList(groupes);
		
	    return listes;
	}
	
	
	public Groupe getGroupe(String nom) {
		
		if (GroupeRepository.containsKey(nom)) {

	        return GroupeRepository.get(nom);
	    } 
		return null;
	}
	
	
	public Groupe addGroupe(Groupe groupe) {
		
		boolean status = true;
	     if(groupe.getNom() == null || groupe.getNom().equals("")){
	    	 status = false;
	     }
	     
	     for(Groupe base : GroupeRepository.values()) {
				if(base.equals(groupe))
					status = false ;
		    } 
	     if(status) {
	    	 GroupeRepository.put(groupe.getNom(),groupe);
	    	 return groupe;
	     }
	     return null;
	}
	
	
	public Groupe updateGroupe(String nom, Groupe groupe) {

	    if (GroupeRepository.containsKey(nom)) {
	        
	    	GroupeRepository.put(nom, groupe);
	        return groupe;
	    } 
	    
	    return null;
	}
	
	public Groupe deleteGroupe(String nom) {

		if (GroupeRepository.containsKey(nom)) {
			return GroupeRepository.remove(nom);
		}
		
		return null;
	}
	
	
	public void deleteGroupes() {

		GroupeRepository.clear();
	}
	
	// Supprime l'etudiant de tous les groupes sauf du groupe actuel specifier en son sein
	public void manageLinkStudentAndGroup(Etudiant etudiant) {
		ArrayList<Groupe> groupes = new ArrayList<Groupe>(GroupeRepository.values());
		for(Groupe groupe : groupes) {
			if(groupe.getMembres().contains(etudiant)) {
				groupe.removeEtudiant(etudiant);
				updateGroupe(groupe.getNom(), groupe);
			}
			if(groupe.getNom().equals(etudiant.getGroupe())) {
				groupe.addEtudiant(etudiant);
				updateGroupe(groupe.getNom(), groupe);
			}
		}
				
	}

}
