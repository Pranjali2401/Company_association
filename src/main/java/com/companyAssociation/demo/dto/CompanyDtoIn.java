package com.companyAssociation.demo.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.companyAssociation.demo.model.ManagerHr;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyDtoIn {

	@NotBlank(message = "Name is Required")
	public String name;

	public Date startedDate;

	@NotBlank
	@Size(min = 2, message = "Domain Name must be more than 2 character")
	public String domain;

	public ManagerHr managerHr;

	@JsonCreator
	public CompanyDtoIn(@JsonProperty("name") String name, @JsonProperty("startedDate") Date startedDate,
			@JsonProperty("domain") String domain, @JsonProperty("managerHr") ManagerHr managerHr) {
		this.name = name;
		this.startedDate = startedDate;
		this.domain = domain;
		this.managerHr = managerHr;
	}
}
