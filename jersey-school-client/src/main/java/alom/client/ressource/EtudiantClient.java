package alom.client.ressource;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import alom.client.back.Etudiant;
import alom.client.back.EtudiantsList;

public class EtudiantClient {
	
	WebResource service;
	
	public EtudiantClient() {

		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		this.service = client.resource("http://localhost:8080/jersey-school-server/webresources/etudiant");
	}
	
	public EtudiantsList getEtudiants(){
		return   service.path("/").accept(MediaType.APPLICATION_JSON_TYPE).get(EtudiantsList.class);
	}
	
	public Etudiant getEtudiant(String ine) {
		return  service.path("/").path(ine).accept(MediaType.APPLICATION_JSON_TYPE).get(Etudiant.class);
	}
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		
		return service.path("/").type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(Etudiant.class,etudiant);
	}
	
	public Etudiant updateEtudiant(String ine, Etudiant etudiant) {
		return service.path("/").path(ine).type(MediaType.APPLICATION_JSON_TYPE).put(Etudiant.class, etudiant);
	}
	
	public void deleteEtudiant(String ine) {
			   service.path("/").path(ine).accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}
	
	public void deleteEtudiants() {
		 	   service.path("/").accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}
	
	public static void main(String[] args) {
		GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        
		EtudiantClient etudiantClient = new EtudiantClient();
		etudiantClient.addEtudiant(new Etudiant("XL2","Dicko","Seydou", null));
		etudiantClient.addEtudiant(new Etudiant("WJ4","Gilles","Charles", null));
		
		System.out.println("Affichage des etudiants .....................................................");
		EtudiantsList listes = etudiantClient.getEtudiants();
		List<Etudiant> etudiants = listes.getEtudiants();
		for(Etudiant one : etudiants )
			System.out.println("Description : "+one.toString());
		
		System.out.println("Modification du prenom de l'etudiant d'ine 'XL2' de 'seydou' => 'salia' .....");
		etudiantClient.updateEtudiant("XL2", new Etudiant("XL2","Dicko","Salia", null));
		
		Etudiant etudiant = etudiantClient.getEtudiant("XL2");
		System.out.println("Description de l'etudiant d'ine 'XL2' ........................................");
		System.out.println(etudiant.toString());
		
		System.out.println("Suppression de l'etudiant d'ine 'WJ4' ........................................");
		etudiantClient.deleteEtudiant("WJ4");
		
		System.out.println("Affichage des etudiants post suppression de 'WJ4'.............................");
		listes = etudiantClient.getEtudiants();
		etudiants = listes.getEtudiants();
		for(Etudiant one : etudiants )
			System.out.println("Description : "+one.toString());
		
		System.out.println("Suppression du reste des etudiants en base....................................");
		etudiantClient.deleteEtudiants();
		
		System.out.println("Affichage des etudiants post suppression total.............................");
		listes = etudiantClient.getEtudiants();
		etudiants = listes.getEtudiants();
		for(Etudiant one : etudiants )
			System.out.println("Description : "+one.toString());
	}
	
}
