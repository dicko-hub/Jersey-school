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

import alom.server.back.Matiere;
import alom.server.back.MatieresList;
import alom.server.controller.MatiereController;

@Path("matiere")
public class MatiereRessource {
	
	MatiereController controller = new MatiereController();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public MatieresList getMatieres() {
		
		MatieresList listes = controller.getMatieres();
		
	    return listes;
	}
	
	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere getMatiere(@PathParam("code") String code) {
		
		Matiere matiere = controller.getMatiere(code);
		
		return matiere;
	    
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere addMatiere(Matiere matiere) {
		
		Matiere matiereAdded = controller.addMatiere(matiere);
		
		return matiereAdded;
	}
	
	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON )
	public Matiere updateMatiere(@PathParam("code") String code, Matiere matiere) {

		Matiere matiereUpdated = controller.updateMatiere(code, matiere);
		
		return matiereUpdated;
	}
	
	@DELETE
	@Path("/{code}")
	public Matiere deleteMatiere(@PathParam("code") String code) {

		return controller.deleteMatiere(code);
	}
	
	@DELETE
	public void deleteMatieres() {

		controller.deleteMatieres();
	}
	
}
