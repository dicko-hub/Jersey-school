package alom.client.back;

import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Etudiant {

	//critere unicité
	private String ine;
	private String nom;
	

	private String prenom;
	private Calendar dateNaissance;
	
	private String groupe;
	
	private ArrayList<Matiere> matieres = new ArrayList<Matiere>();
	
	public Etudiant() {
		
	}

	public Etudiant(String ine, String nom, String prenom, Calendar dateNaissance) {
		
		this.ine = ine;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public Etudiant(String ine, String nom, String prenom, Calendar dateNaissance, String groupe) {
		
		this.ine = ine;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.groupe = groupe;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Calendar getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public ArrayList<Matiere> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(ArrayList<Matiere> matieres) {
		this.matieres = matieres;
	}

	public void addMatiere(Matiere matiere) {
		this.matieres.add(matiere);
	}
	
	public void removeMatiere(Matiere matiere) {
		this.matieres.remove(matiere);
	}
	
	public Matiere getMatiere(String code) {
		for(Matiere matiere : this.matieres)
			if(matiere.getCode().equals(code))
				return matiere;
		
		return null;
	}
	
	public String getIne() {
		return ine;
	}


	@Override
	public String toString() {
		return "Etudiant [ine=" + ine + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", groupe=" + groupe + ", matieres=" + matieres + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ine == null) ? 0 : ine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (ine == null) {
			if (other.ine != null)
				return false;
		} else if (!ine.equals(other.ine))
			return false;
		return true;
	}

	
}
