package alom.client.ressource;

import java.util.ArrayList;
import javax.ws.rs.core.MediaType;


import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import alom.client.back.Etudiant;
import alom.client.back.Groupe;
import alom.client.back.GroupesList;

public class GroupeClient {

WebResource service;
	
	public GroupeClient() {
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		this.service = client.resource("http://localhost:8080/jersey-school-server/webresources/groupe");
	}
	
	public GroupesList getGroupes(){
		return service.path("/").accept(MediaType.APPLICATION_JSON_TYPE).get(GroupesList.class);
	}
	
	public Groupe getGroupe(String nom) {
		return  service.path("/").path(nom).accept(MediaType.APPLICATION_JSON_TYPE).get(Groupe.class);
	}
	
	public Groupe addGroupe(Groupe groupe) {
		
		return service.path("/").type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(Groupe.class,groupe);
	}
	
	public Groupe updateGroupe(String nom, Groupe groupe) {
		return service.path("/").path(nom).type(MediaType.APPLICATION_JSON_TYPE).put(Groupe.class, groupe);
	}
	
	public void deleteGroupe(String nom) {
			   service.path("/").path(nom).accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}
	
	public void deleteGroupes() {
		 	   service.path("/").accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}
	
	public static void main(String[] args) {
		
		GroupeClient grcl = new GroupeClient();
		grcl.addGroupe(new Groupe("one"));
		grcl.addGroupe(new Groupe("two"));
		
		Etudiant xl2 = new Etudiant("XL2","Dicko","Seydou", null,"one");
		Etudiant wj4 = new Etudiant("WJ4","Gilles","Charles", null,"one");
		Etudiant xl3 = new Etudiant("XL3","nom 1","prenom 1", null, "two");
		Etudiant wj5 = new Etudiant("WJ5","nom 2","prenom 2", null,"two");
		
		EtudiantClient etudiantClient = new EtudiantClient();
		etudiantClient.addEtudiant(xl2);
		etudiantClient.addEtudiant(wj4);
		etudiantClient.addEtudiant(xl3);
		etudiantClient.addEtudiant(wj5);
		
		System.out.println("Description de tout les groupes en base .............................");
		GroupesList listesGroupes = grcl.getGroupes();
		ArrayList<Groupe> groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description : "+one.toString());
		
		System.out.println("Modification du prenom des membres du groupe 2.........................");
		for(Etudiant one : etudiantClient.getEtudiants().getEtudiants())
			if(one.getGroupe().equals("two")) {
				one.setPrenom("Nouveau prenom ");
				etudiantClient.updateEtudiant(one.getIne(), one);
			}
		
		System.out.println("Description du groupe 2 post modification .............................");
		Groupe groupe = grcl.getGroupe("two");
		System.out.println("Description groupe 2: "+groupe.toString());
		
		System.out.println("Suppression du groupe 1 de la liste .....................................");
		grcl.deleteGroupe("one");
		
		System.out.println("Description des groupes post suppression du groupe 1....................");
		listesGroupes = grcl.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description : "+one.toString());
		
		System.out.println("Suppression de tout les groupes ...........................................");
		grcl.deleteGroupes();
		
		System.out.println("Description des groupes post suppression total ............................");
		listesGroupes = grcl.getGroupes();
		groupes = listesGroupes.getGroupes();
		for(Groupe one : groupes)
			System.out.println("Description : "+one.toString());
	}
}
