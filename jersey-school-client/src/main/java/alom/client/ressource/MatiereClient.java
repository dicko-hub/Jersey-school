package alom.client.ressource;


import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import alom.client.back.Matiere;
import alom.client.back.MatieresList;

public class MatiereClient {

	WebResource service;
	
	public MatiereClient() {

		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		this.service = client.resource("http://localhost:8080/jersey-school-server/webresources/matiere");
	}
	
	public MatieresList getMatieres(){
		return service.path("/").accept(MediaType.APPLICATION_JSON_TYPE).get(MatieresList.class);
	}
	
	public Matiere getMatiere(String code) {
		return  service.path("/").path(code).accept(MediaType.APPLICATION_JSON_TYPE).get(Matiere.class);
	}
	
	public Matiere addMatiere(Matiere matiere) {
		
		return service.path("/").type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(Matiere.class,matiere);
	}
	
	public Matiere updateMatiere(String code, Matiere matiere) {
		return service.path("/").path(code).type(MediaType.APPLICATION_JSON_TYPE).put(Matiere.class, matiere);
	}
	
	public void deleteMatiere(String code) {
			   service.path("/").path(code).accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}
	
	public void deleteMatieres() {
		 	   service.path("/").accept(MediaType.APPLICATION_JSON_TYPE).delete();
	}
	
	public static void main(String[] args) {
		
		MatiereClient mtcl = new MatiereClient();
		mtcl.addMatiere(new Matiere("NDD","NoSql","Parcours BI","Mme X"));
		mtcl.addMatiere(new Matiere("ARI","Archi","Parcours Dev","M Y"));

		System.out.println("Affichage de toutes les matieres ..................................");
		MatieresList listes = mtcl.getMatieres();
		ArrayList<Matiere> matieres = listes.getMatieres();
		for(Matiere one : matieres )
			System.out.println("Description : "+one.toString());
		
		System.out.println("Modification du nom de la matiere de code 'ARI' de 'Archi' a 'Infra' ...");
		Matiere matiere = mtcl.getMatiere("ARI");		
		matiere.setNom("Infra");
		mtcl.updateMatiere("ARI", matiere);
		
		System.out.println("Affichage de la matiere de code 'ARI' post modifcation................");
		matiere = mtcl.getMatiere("ARI");
		System.out.println("Description : "+matiere.toString());
		
		System.out.println("Suppression de la matiere 'ARI' de la liste .........................");
		mtcl.deleteMatiere("ARI");
		
		System.out.println("Affichage des matieres post suppression de 'ARI'................");
		listes = mtcl.getMatieres();
		matieres = listes.getMatieres();
		for(Matiere one : matieres )
			System.out.println("Description : "+one.toString());
		
		
		System.out.println("Suppression du reste des matieres de la liste ..........................");
		mtcl.deleteMatieres();
		
		System.out.println("Affichage des matieres post suppression total................");
		listes = mtcl.getMatieres();
		matieres = listes.getMatieres();
		for(Matiere one : matieres )
			System.out.println("Description : "+one.toString());
		
	}
}
