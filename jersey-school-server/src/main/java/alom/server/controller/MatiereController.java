package alom.server.controller;

import java.util.ArrayList;
import java.util.Map;

import alom.server.back.Etudiant;
import alom.server.back.Matiere;
import alom.server.back.MatieresList;
import alom.server.back.Repository;

public class MatiereController {
	
	private static Map<String,Matiere> MatiereRepository = Repository.getInstance().getMatieres();
	EtudiantController etudiantController = new EtudiantController();

	public MatieresList getMatieres() {
		
		ArrayList<Matiere> matieres = new ArrayList<Matiere>(MatiereRepository.values());
		MatieresList listes = new MatieresList(matieres);
		
	    return listes;
	}
	
	public Matiere getMatiere( String code) {
		
		if (MatiereRepository.containsKey(code)) {

	        return MatiereRepository.get(code);
	    }
		return null;
	    
	}
	
	public Matiere addMatiere(Matiere matiere) {
		
		boolean status = true;
	     if(matiere.getCode() == null || matiere.getCode().equals("")){
	    	 status = false;
	     }
	     
	     for(Matiere base : MatiereRepository.values()) {
				if(base.equals(matiere))
					status = false;
		    } 
	     
	     if(status) {
	    	 MatiereRepository.put(matiere.getCode(),matiere);
	    	 addForAllStudent(matiere);
	    	 return matiere;
	     }
		     
	     return null;
	}
	
	
	public Matiere updateMatiere(String code, Matiere matiere) {

		
	    if (MatiereRepository.containsKey(code)) {
	        
	    	MatiereRepository.put(code, matiere);
	        return matiere;
	    } 
	    return null;
	}
	
	public Matiere deleteMatiere(String code) {

		if (MatiereRepository.containsKey(code)) {
			return MatiereRepository.remove(code);
		}
		
		return null;
	}
	
	public void deleteMatieres() {

		MatiereRepository.clear();
	}
	
	private void addForAllStudent(Matiere matiere) {
		for(Etudiant etudiant : etudiantController.getEtudiants().getEtudiants()) {
			etudiant.addMatiere(matiere);
			etudiantController.updateEtudiant(etudiant.getIne(), etudiant);
		}
	}

}
