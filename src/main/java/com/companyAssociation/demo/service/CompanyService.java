package com.companyAssociation.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.CompanyDao;
import com.companyAssociation.demo.dao.ManagerHrDao;
import com.companyAssociation.demo.model.Company;
import com.companyAssociation.demo.model.Job;
import com.companyAssociation.demo.model.ManagerHr;

@Service
public class CompanyService {

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ManagerHrDao mhDao;

	public Company addCompany(Company company) {	
		Company com = companyDao.save(company);
		return com;

	}
	
	public Company addManager(long companyId, long managerId) {
		Company co = companyDao.findById(companyId).get();
		ManagerHr mh = mhDao.findById(managerId).get();
	
		co.setManagerHr(mh);
		Company com =  companyDao.save(co);
		return com;
	}
	
	public Company getCompany(long id) {
		return companyDao.findById(id).get();
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
