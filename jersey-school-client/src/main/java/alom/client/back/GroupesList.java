package alom.client.back;

import java.util.ArrayList;

public class GroupesList {

	private ArrayList<Groupe> groupes;

	
	public GroupesList() {
		
	}


	public GroupesList(ArrayList<Groupe> groupes) {
		
		this.groupes = groupes;
	}


	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}


	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
	
	
}
