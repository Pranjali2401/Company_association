package com.companyAssociation.demo.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.companyAssociation.demo.model.ManagerHr;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyDtoOut {

	public long id;
	public String name;
	public Date startedDate;
	public String domain;
	public ManagerHr managerHr;

	public CompanyDtoOut() {}
	
	@JsonCreator
	public CompanyDtoOut(@JsonProperty("id") long id, @JsonProperty("name") String name,
			@JsonProperty("startedDate") Date startedDate, @JsonProperty("domain") String domain,
			@JsonProperty("managerHr") ManagerHr managerHr) {
		this.id = id;
		this.name = name;
		this.startedDate = startedDate;
		this.domain = domain;
		this.managerHr = managerHr;
	}
}
