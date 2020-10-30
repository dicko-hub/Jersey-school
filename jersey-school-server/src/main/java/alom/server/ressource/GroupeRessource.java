package alom.server.ressource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import alom.server.back.Groupe;
import alom.server.back.GroupesList;
import alom.server.controller.GroupeController;

@Path("/groupe")
public class GroupeRessource {
	
	GroupeController controller = new GroupeController();
	

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public GroupesList getGroupes() {
		
		GroupesList listes = controller.getGroupes();
		
	    return listes;
	}
	
	@GET
	@Path("/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Groupe getGroupe(@PathParam("nom") String nom) {
		
		Groupe groupe = controller.getGroupe(nom);
		
		return groupe;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Groupe addGroupe(Groupe groupe) {
		
		Groupe groupeAdded = controller.addGroupe(groupe);
		
		return groupeAdded;
	}
	
	@PUT
	@Path("/{nom}")
	@Consumes(MediaType.APPLICATION_JSON )
	public Groupe updateGroupe(@PathParam("nom") String nom, Groupe groupe) {

	    Groupe groupeUpdated = controller.updateGroupe(nom, groupe);
	    
	    return groupeUpdated;
	}
	
	@DELETE
	@Path("/{nom}")
	public Groupe deleteGroupe(@PathParam("nom") String nom) {

		return controller.deleteGroupe(nom);
	}
	
	@DELETE
	public void deleteGroupes() {

		controller.deleteGroupes();
	}
	
}
