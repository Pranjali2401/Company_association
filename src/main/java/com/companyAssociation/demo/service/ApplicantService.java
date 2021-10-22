package com.companyAssociation.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.ApplicantDao;
import com.companyAssociation.demo.model.Applicant;

@Service
public class ApplicantService {

	@Autowired
	ApplicantDao applicantDao;

	public Applicant addApplicant(Applicant applicant) {
		Applicant app = applicantDao.save(applicant);
		return app;
		
	}
	
	public Applicant getApplicant(long id) {
		Applicant app = applicantDao.findById(id).get();
		return app;
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
