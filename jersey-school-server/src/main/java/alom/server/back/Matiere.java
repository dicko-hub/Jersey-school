package alom.server.back;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Matiere {
	
	private String code;
	private String nom;
	private String description;
	private String nomProfesseur;
	private int note;
	
	public Matiere() {
		
	}
	
	public Matiere(String code, String nom, String description, String nomProfesseur) {
		
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.nomProfesseur = nomProfesseur;
	}

	
	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomProfesseur() {
		return nomProfesseur;
	}

	public void setNomProfesseur(String nomProfesseur) {
		this.nomProfesseur = nomProfesseur;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return "Matiere [code=" + code + ", nom=" + nom + ", description=" + description + ", nomProfesseur="
				+ nomProfesseur + ", note=" + note + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Matiere other = (Matiere) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
	
}
