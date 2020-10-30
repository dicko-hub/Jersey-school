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
import alom.server.back.Etudiant;
import alom.server.back.EtudiantsList;
import alom.server.controller.EtudiantController;

@Path("/etudiant")
public class EtudiantRessource {
	
	EtudiantController controller = new EtudiantController();
	

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public EtudiantsList getEtudiants() {
		
		EtudiantsList listes = controller.getEtudiants();
		
	    return listes;
	}
	
	@GET
	@Path("/{ine}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@PathParam("ine") String ine) {
		
		Etudiant etudiant = controller.getEtudiant(ine);
		
		return etudiant;
	    
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant addEtudiant(Etudiant etudiant) {
		
		Etudiant etudiantAdded = controller.addEtudiant(etudiant);
		return etudiantAdded;
	     
	}
	
	@PUT
	@Path("/{ine}")
	@Consumes(MediaType.APPLICATION_JSON )
	public Etudiant updateEtudiant(@PathParam("ine") String ine, Etudiant etudiant) {

		Etudiant etudiantUpdated = controller.updateEtudiant(ine, etudiant);
		
		return etudiantUpdated;
	    
	}
	
	@DELETE
	@Path("/{ine}")
	public Etudiant deleteEtudiant(@PathParam("ine") String ine) {

		return controller.deleteEtudiant(ine);
	}
	
	@DELETE
	public void deleteEtudiants() {

		controller.deleteEtudiants();
	}
	
}
