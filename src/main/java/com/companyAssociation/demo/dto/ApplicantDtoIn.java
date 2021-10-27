package com.companyAssociation.demo.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicantDtoIn {

	@NotEmpty(message = "Applicant name required")
	public String name;
	
	@NotEmpty(message = "Please Enter Skills")
	public String skills[];

	@JsonCreator
	public ApplicantDtoIn(@JsonProperty("name") String name, @JsonProperty("skills") String skills[]) {

		this.name = name;
		this.skills = skills;
	}
}
