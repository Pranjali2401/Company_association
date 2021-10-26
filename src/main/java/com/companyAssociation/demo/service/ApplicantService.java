package com.companyAssociation.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.ApplicantDao;
import com.companyAssociation.demo.dto.ApplicantDtoIn;
import com.companyAssociation.demo.dto.ApplicantDtoOut;
import com.companyAssociation.demo.model.Applicant;

@Service
public class ApplicantService {

	@Autowired
	ApplicantDao applicantDao;
	
//	convert into entity
	public Applicant buildApplicant(ApplicantDtoIn appDtoIn) {
		Applicant app = new Applicant();
		app.setName(appDtoIn.name);
		app.setSkills(appDtoIn.skills);
		return app;
	}

//	convert into dto
	public ApplicantDtoOut buildApplicantDto(Applicant applicant) {
		ApplicantDtoOut appDtoOut = new ApplicantDtoOut();
		appDtoOut.id = applicant.getId();
		appDtoOut.name = applicant.getName();
		appDtoOut.skills = applicant.getSkills();
		return appDtoOut;
		
	}
	public ApplicantDtoOut addApplicant(ApplicantDtoIn applicant) {
		Applicant app = buildApplicant(applicant);
		app = applicantDao.save(app);
		
		return buildApplicantDto(app);
		
	}
	
	public ApplicantDtoOut getApplicant(long id) {
		Applicant app = applicantDao.findById(id).get();
		return buildApplicantDto(app);
	}
	
	public void updateApplicant(Applicant applicant, long id) {
		Applicant app = applicantDao.findById(id).get();
		app.setName(applicant.getName());
		app.setSkills(applicant.getSkills());
		app.setAppliedJob(applicant.getAppliedJob());
		
		applicantDao.save(app);
	}
	
	public void deleteApplicant(long id) {
		applicantDao.deleteById(id);
	}
	
}
