package alom.server.controller;

import java.util.ArrayList;
import java.util.Map;

import alom.server.back.Etudiant;
import alom.server.back.EtudiantsList;
import alom.server.back.Groupe;
import alom.server.back.Repository;

public class EtudiantController {
	private static Map<String,Etudiant> EtudiantRepository = Repository.getInstance().getEtudiants();
	
	GroupeController groupeController = new GroupeController();
	

	public EtudiantsList getEtudiants() {
		
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>(EtudiantRepository.values());
		EtudiantsList listes = new EtudiantsList(etudiants);
		
	    return listes;
	}
	
	public Etudiant getEtudiant(String ine) {
		
		if (EtudiantRepository.containsKey(ine)) {

	        return EtudiantRepository.get(ine);
	    } 
		return null;
	    
	}
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		
		boolean status = true;
		
	     if(etudiant.getIne() == null || etudiant.getIne().equals("")){
	    	 status = false;
	     }
	     
	     for(Etudiant base : EtudiantRepository.values()) {
				if(base.equals(etudiant))
					status =  false;
		    } 
	     if(status) {
	    	 
	    	 EtudiantRepository.put(etudiant.getIne(),etudiant);
	    	 groupeController.manageLinkStudentAndGroup(etudiant);
	    	 return etudiant;
	     }
	     return null;
	     
	}
	
	public Etudiant updateEtudiant( String ine, Etudiant etudiant) {

		if (EtudiantRepository.containsKey(ine)) {
	        
	    	EtudiantRepository.put(ine, etudiant);
	    	groupeController.manageLinkStudentAndGroup(etudiant);
	    	return etudiant;
	    } 
		
		return null;
	    
	}
	
	public Etudiant deleteEtudiant(String ine) {

		// recuperation du groupe de l'etudiant 
		Groupe groupe = groupeController.getGroupe(getEtudiant(ine).getGroupe());
		
		// suppression de l'etudiant de son groupe
		if(groupe != null) {
			groupe.removeEtudiant(getEtudiant(ine));
			groupeController.updateGroupe(groupe.getNom(), groupe);
		}
		
		if (EtudiantRepository.containsKey(ine)) {
			return EtudiantRepository.remove(ine);
		}
		
		return null;
		
	}
	
	public void deleteEtudiants() {

		EtudiantRepository.clear();
		groupeController.deleteGroupes();
	}
	
}
