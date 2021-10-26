package com.companyAssociation.demo.service;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.CompanyDao;
import com.companyAssociation.demo.dao.ManagerHrDao;
import com.companyAssociation.demo.dto.CompanyDtoIn;
import com.companyAssociation.demo.dto.CompanyDtoOut;
import com.companyAssociation.demo.model.Company;
import com.companyAssociation.demo.model.Job;
import com.companyAssociation.demo.model.ManagerHr;

@Service
public class CompanyService {

	@Autowired
	CompanyDao companyDao;

	@Autowired
	ManagerHrDao mhDao;
	
//	Change into dto
	public CompanyDtoOut buildCompanyDto(Company company) {
		CompanyDtoOut comDto = new CompanyDtoOut();
		
		comDto.id = company.getId();
		comDto.name = company.getName();
		comDto.domain = company.getDomain();
		comDto.startedDate = company.getStartedDate();
		comDto.managerHr = company.getManagerHr();	
		
		return comDto;
	}
//	Change into Entity
	
	public Company buildCompany(CompanyDtoIn comDtoIn) {
		Company company = new Company();
		company.setName(comDtoIn.name);
		company.setDomain(comDtoIn.domain);
		company.setStartedDate(comDtoIn.startedDate);
		company.setManagerHr(comDtoIn.managerHr);
		
		return company;
	}
	

	public CompanyDtoOut addCompany(CompanyDtoIn company) {
		Company com = buildCompany(company);
		com = companyDao.save(com);
		return buildCompanyDto(com);

	}

	public Company addManager(long companyId, long managerId) {
		Company co = companyDao.findById(companyId).get();
		ManagerHr mh = mhDao.findById(managerId).get();

		co.setManagerHr(mh);
		Company com = companyDao.save(co);
		return com;

	}

	public CompanyDtoOut getCompany(long id) {
		Company com = companyDao.findById(id).get();
		return buildCompanyDto(com);
	}

	public void updateCompany(Company company, long id) {
		Company com = companyDao.findById(id).get();
		com.setDomain(company.getDomain());
		com.setManagerHr(company.getManagerHr());
		com.setName(company.getName());
		com.setOpenJobs(company.getOpenJobs());
		com.setStartedDate(com.getStartedDate());

		companyDao.save(com);

	}

	public void deleteCompany(long id) {
//		Company com = companyDao.findById(id).get();
//		ManagerHr managerId = com.getManagerHr();
//		long mId = managerId.getId();
//		mhDao.deleteById(mId);
		companyDao.deleteById(id);
	}
}
