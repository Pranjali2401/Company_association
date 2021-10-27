package com.companyAssociation.demo.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagerHrDtoIn {

	@NotEmpty(message = "Name is Required")
	public String name;

	@JsonCreator
	public ManagerHrDtoIn(@JsonProperty("name") String name) {
		this.name = name;
	}

}
