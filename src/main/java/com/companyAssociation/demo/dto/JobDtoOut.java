package com.companyAssociation.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.companyAssociation.demo.model.Applicant;
import com.companyAssociation.demo.model.Company;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobDtoOut {
	
	public long id;
	public String jobTitle;
	public String requiredSkill[];
	public long payScale;
	public Company company;
	public Set<Applicant> jobApplications = new HashSet<>();

	public JobDtoOut() {}
	
	@JsonCreator
	public JobDtoOut(@JsonProperty("jobTitle") String jobTitle,@JsonProperty("requiredSkill") String requiredSkill[], @JsonProperty("payScale") long payScale) {
		this.jobTitle = jobTitle;
		this.requiredSkill = requiredSkill;
		this.payScale = payScale;
		
	}
}
