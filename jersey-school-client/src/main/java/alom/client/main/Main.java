package alom.client.main;

import java.util.ArrayList;

import alom.client.back.Etudiant;
import alom.client.back.Groupe;
import alom.client.back.GroupesList;
import alom.client.back.Matiere;
import alom.client.ressource.EtudiantClient;
import alom.client.ressource.GroupeClient;
import alom.client.ressource.MatiereClient;

public class Main {
	
	public static void main(String[] args) {
		EtudiantClient etudiantClient = new EtudiantClient();
		MatiereClient matiereClient = new MatiereClient();
		GroupeClient groupeClient = new GroupeClient();
		
		//Ajout et suppression d'etudiant à un groupe avec un groupe par etudiant
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		System.out.println("Ajout et suppression d'etudiant à un groupe avec un groupe par etudiant");
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		GroupeClient grcl = new GroupeClient();
		grcl.addGroupe(new Groupe("one"));
		grcl.addGroupe(new Groupe("two"));
		
		Etudiant xl2 = new Etudiant("XL2","Dicko","Seydou", null,"one");
		Etudiant wj4 = new Etudiant("WJ4","Gilles","Charles", null);
		Etudiant xl3 = new Etudiant("XL3","nom 1","prenom 1", null, "two");
		Etudiant wj5 = new Etudiant("WJ5","nom 2","prenom 2", null,"two");
		
		etudiantClient.addEtudiant(xl2);
		etudiantClient.addEtudiant(wj4);
		etudiantClient.addEtudiant(xl3);
		etudiantClient.addEtudiant(wj5);
		
		System.out.println("Description de tous les groupes en base .............................");
		GroupesList listesGroupes = groupeClient.getGroupes();
		ArrayList<Groupe> groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description : "+one.toString());
		
		
		System.out.println("Ajout de l'etudiant d'ine 'WJ4' au groupe 2 .........................");
		wj4.setGroupe("two");
		etudiantClient.updateEtudiant(wj4.getIne(), wj4);
		
		System.out.println("Description de tous les groupes en base .............................");
		listesGroupes = groupeClient.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description : "+one.toString());
		
		System.out.println("Suppression de l'etudiant d'ine 'XL3' au groupe 2 et son ajout au groupe 1.........................");
		//xl3.setGroupe(null); // pour l'enlever d'un groupe
		xl3.setGroupe("one");
		etudiantClient.updateEtudiant(xl3.getIne(), xl3);
		
		System.out.println("Description de tous les groupes en base .............................");
		listesGroupes = groupeClient.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description : "+one.toString());
		
		
		
		//Creation et suppression de lien entre groupe et matiere avec un groupe pour plusieurs matieres
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		System.out.println("Creation et suppression de lien entre groupe et matiere avec un groupe pour plusieurs matieres");
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		matiereClient.addMatiere(new Matiere("NDD","NoSql","Parcours BI","Mme W"));
		matiereClient.addMatiere(new Matiere("ARI 1","Archi","Parcours Dev 1","M. X"));
		matiereClient.addMatiere(new Matiere("ARI 2","Autonomie","Parcours Dev 2","M. Y"));
		matiereClient.addMatiere(new Matiere("ALOM","Micro-service","Parcours Dev 3","M. Z"));
		
		Groupe groupe = groupeClient.getGroupe("one");
		groupe.addMatiere(matiereClient.getMatiere("NDD"));
		groupeClient.updateGroupe("one", groupe);
		
		groupe = groupeClient.getGroupe("two");
		groupe.addMatiere(matiereClient.getMatiere("ARI 2"));
		groupe.addMatiere(matiereClient.getMatiere("ALOM"));
		groupeClient.updateGroupe("two", groupe);
		
		System.out.println("Description de tous les groupes en base pour voir les matieres.............................");
		listesGroupes = groupeClient.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description groupe "+one.getNom() +" : "+one.getMatieres().toString());
		
		System.out.println("Ajout de la matiere 'ARI 1' au groupe 2 .........................");
		groupe = groupeClient.getGroupe("two");
		groupe.addMatiere(matiereClient.getMatiere("ARI 1"));
		groupeClient.updateGroupe("two", groupe);
		
		System.out.println("Description de tous les groupes en base .............................");
		listesGroupes = groupeClient.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description groupe "+one.getNom() +" : "+one.getMatieres().toString());
		
		System.out.println("Suppression de la matiere 'ALOM' au groupe 2 et son ajout au groupe 1.........................");
		groupe = groupeClient.getGroupe("two");
		groupe.removeMatiere(matiereClient.getMatiere("ALOM"));
		groupeClient.updateGroupe("two", groupe);
		groupe = groupeClient.getGroupe("one");
		groupe.addMatiere(matiereClient.getMatiere("ALOM"));
		groupeClient.updateGroupe("one", groupe);
		
		System.out.println("Description de tous les groupes en base .............................");
		listesGroupes = groupeClient.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description groupe "+one.getNom() +" : "+one.getMatieres().toString());
		
		
		//Donner, modifier & supprimer des notes dans une matière à un étudiant
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		System.out.println("Donner, modifier & supprimer des notes dans une matière à un étudiant");
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		
		System.out.println("Description de l'etudiant d'ine 'XL2'..........................................");
		xl2 = etudiantClient.getEtudiant("XL2");
		System.out.println("Description : "+xl2.toString());
		
		
		System.out.println("Allocation de note a 'ALOM' de l'etudiant d'ine 'XL2'..........................");
		Matiere matiere = xl2.getMatiere("ALOM");
		xl2.removeMatiere(matiere);
		matiere.setNote(17);
		xl2.addMatiere(matiere);
		etudiantClient.updateEtudiant(xl2.getIne(), xl2);
		
		System.out.println("Description de l'etudiant d'ine 'XL2' post allocation de note ..................");
		xl2 = etudiantClient.getEtudiant("XL2");
		System.out.println("Description : "+xl2.toString());
		
		System.out.println("Modification de note a 'ALOM' de l'etudiant d'ine 'XL2'..........................");
		matiere = xl2.getMatiere("ALOM");
		xl2.removeMatiere(matiere);
		matiere.setNote(12);
		xl2.addMatiere(matiere);
		etudiantClient.updateEtudiant(xl2.getIne(), xl2);
		
		System.out.println("Description de l'etudiant d'ine 'XL2' post modification de note ..................");
		xl2 = etudiantClient.getEtudiant("XL2");
		System.out.println("Description : "+xl2.toString());
		
		
		System.out.println("Suppression de note a 'ALOM' de l'etudiant d'ine 'XL2'..........................");
		matiere = xl2.getMatiere("ALOM");
		xl2.removeMatiere(matiere);
		matiere.removeNote();
		xl2.addMatiere(matiere);
		etudiantClient.updateEtudiant(xl2.getIne(), xl2);
		
		System.out.println("Description de l'etudiant d'ine 'XL2' post suppression de note ..................");
		xl2 = etudiantClient.getEtudiant("XL2");
		System.out.println("Description : "+xl2.toString());
		
		
		//Afficher le tableau des résultats (ensemble des notes des étudiants, regroupés par matière et groupe
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		System.out.println("Afficher le tableau des résultats (ensemble des notes des étudiants, regroupés par matière et groupe");
		System.out.println("............................................................................");
		System.out.println("............................................................................");
		
		
		
		groupes = groupeClient.getGroupes().getGroupes();
		System.out.println(".................................................................................");
		System.out.println("GROUPES..................MATIERES...........................NOTES");
		
		for(Groupe team : groupes) {
			System.out.println("GROUPE : "+team.getNom().toUpperCase()+"...................................................................");
			for(Etudiant elt : team.getMembres() ) {
				System.out.println(elt.getNom().toUpperCase()+"...................................................................");
				for(Matiere mat : elt.getMatieres()) {
						System.out.println("                           "+mat.getCode().toUpperCase()+"                            "+mat.getNote()+"     ");
				}
			}
		}
		
		
		
		/**
		 * PROBLEME GESTION DES EXCEPTIONS EN TRY CATCH COTE CLIENT ?
		 */
	}
}
