package alom.server.back;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Groupe {
	
	private String nom;
	
	private ArrayList<Etudiant> membres = new ArrayList<Etudiant>();
	private ArrayList<Matiere> matieres = new ArrayList<Matiere>();

	public Groupe() {
		
	}
	
	public Groupe(String nom) {
		
		this.nom = nom;
	}
	
	

	public ArrayList<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(ArrayList<Matiere> matieres) {
		this.matieres = matieres;
	}

	public String getNom() {
		return nom;
	}

	public ArrayList<Etudiant> getMembres() {
		return membres;
	}

	public void setMembres(ArrayList<Etudiant> membres) {
		this.membres = membres;
	}
	
	public void addEtudiant(Etudiant etudiant) {
		this.membres.add(etudiant);
	}
	
	public void removeEtudiant(Etudiant etudiant) {
		this.membres.remove(etudiant);
	}
	
	public void addMatiere(Matiere matiere) {
		this.matieres.add(matiere);
	}
	
	public void removeMatiere(Matiere matiere) {
		this.matieres.remove(matiere);
	}
	
	public Etudiant getEtudiant(String ine) {
		for(Etudiant etudiant : this.membres)
			if(etudiant.getIne().equals(ine))
				return etudiant;
		return null;
	}
	
	@Override
	public String toString() {
		return "Groupe [nom=" + nom + ", membres=" + membres + ", matieres=" + matieres + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Groupe other = (Groupe) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
	

}
