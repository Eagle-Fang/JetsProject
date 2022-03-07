package com.skilldistillery.jets.entities;


import java.util.ArrayList;

import java.util.List;


public class AirField {

	private List <Jet> jets;
	
	public AirField () {
		jets = new ArrayList<Jet> ();
	}
	
	public List<Jet> getJets() {
	return jets;	
	}
	
	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
	
	
	public void addNewJet (Jet newJet) {
		jets.add(newJet);
		}
	
	public void removeJet (int index) {
		jets.remove(index);
		}
	
	
			
}
