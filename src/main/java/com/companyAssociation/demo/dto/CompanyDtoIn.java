package com.companyAssociation.demo.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.companyAssociation.demo.model.ManagerHr;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyDtoIn {

	@NotBlank(message = "Name is Required")
	public String name;

	public Date startedDate;

	@NotBlank(message = "Domain is Required")
	public String domain;

	public ManagerHr managerHr;

	public CompanyDtoIn(@JsonProperty("name") String name, @JsonProperty("startedDate") Date startedDate,
			@JsonProperty("domain") String domain, @JsonProperty("managerHr") ManagerHr managerHr) {
		this.name = name;
		this.startedDate = startedDate;
		this.domain = domain;
		this.managerHr = managerHr;
	}
}
