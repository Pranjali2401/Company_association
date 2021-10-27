package com.companyAssociation.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagerHrDtoOut {

	public long id;
	public String name;

	public ManagerHrDtoOut() {}
	
	@JsonCreator
	public ManagerHrDtoOut(@JsonProperty("id") long id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

}
