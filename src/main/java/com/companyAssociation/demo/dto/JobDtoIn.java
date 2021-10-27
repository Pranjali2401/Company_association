package com.companyAssociation.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobDtoIn {

	@NotEmpty
	public String jobTitle;
	
	@NotEmpty
	public String requiredSkill[];
	
	@NotNull
	public long payScale;
	
	@JsonCreator
	public JobDtoIn(@JsonProperty("jobTitle") String jobTitle,@JsonProperty("requiredSkill") String requiredSkill[], @JsonProperty("payScale") long payScale) {
		this.jobTitle = jobTitle;
		this.requiredSkill = requiredSkill;
		this.payScale = payScale;
		
	}


}
