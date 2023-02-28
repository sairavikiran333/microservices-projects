package com.brv.models;

public class People {

	public People() {
	}

	
	String actorId;
	String actorName;
	String actorBiography;
	
	public People(String actorId, String actorName, String actorBiography) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.actorBiography = actorBiography;
	}

	public String getActorId() {
		return actorId;
	}

	public void setActorId(String actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorBiography() {
		return actorBiography;
	}

	public void setActorBiography(String actorBiography) {
		this.actorBiography = actorBiography;
	}
	
	
}
