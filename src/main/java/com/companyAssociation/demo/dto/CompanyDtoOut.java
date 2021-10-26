package com.companyAssociation.demo.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.companyAssociation.demo.model.ManagerHr;

public class CompanyDtoOut {


	public long id;
	public String name;
	public Date startedDate;
	public String domain;
	public ManagerHr managerHr;
}
