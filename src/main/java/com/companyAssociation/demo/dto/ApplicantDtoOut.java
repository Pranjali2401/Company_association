package com.companyAssociation.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicantDtoOut {


	public long id;
	public String name;
	public String skills[];
	
	public ApplicantDtoOut() {}
	
	@JsonCreator
	public ApplicantDtoOut(@JsonProperty("id") long id ,@JsonProperty("name") String name, @JsonProperty("skills") String skills[]) {
		this.id = id;
		this.name = name;
		this.skills = skills;
	}
}
