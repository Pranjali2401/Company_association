package com.companyAssociation.demo.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ManagerHrDtoIn {

	@NotBlank(message = "Name is Required")
	public String name;
	
	public ManagerHrDtoIn(@JsonProperty("name") String name) {
	    this.name = name;
	}


}
