package com.companyAssociation.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.ApplicantDao;
import com.companyAssociation.demo.dao.CompanyDao;
import com.companyAssociation.demo.dao.JobDao;
import com.companyAssociation.demo.dto.JobDtoIn;
import com.companyAssociation.demo.dto.JobDtoOut;
import com.companyAssociation.demo.model.Applicant;
import com.companyAssociation.demo.model.Company;
import com.companyAssociation.demo.model.Job;

@Service
public class JobService {

	@Autowired
	JobDao jobDao;

	@Autowired
	ApplicantDao appDao;

	@Autowired
	CompanyDao companyDao;
	
//	convert into dto
	public JobDtoOut buildJobDto(Job job) {
		
		JobDtoOut jobDto = new JobDtoOut();
		
		jobDto.id = job.getId();
		jobDto.jobTitle = job.getJobTitle();
		jobDto.requiredSkill = job.getRequiredSkill();
		jobDto.company = job.getCompany();
		jobDto.jobApplications = job.getJobApplication();
		return jobDto;
	}

	public Job buildJob(JobDtoIn jobDto) {
		Job job = new Job();
		
		job.setJobTitle(jobDto.jobTitle);
		job.setPayScale(jobDto.payScale);
		job.setRequiredSkill(jobDto.requiredSkill);
		
		return job;
	}
	public JobDtoOut addJob(JobDtoIn j) {
		Job job = buildJob(j);
		job = jobDao.save(job);
		return buildJobDto(job);
	}

	public Job addCompany(long jobId, long companyId) {
		Job job = jobDao.findById(jobId).get();
		Company com = companyDao.findById(companyId).get();

		job.setCompany(com);
		Job j = jobDao.save(job);
		return j;

	}

	public Job addApplicant(long jobId, long applicantId) {
		Job job = jobDao.findById(jobId).get();
		Applicant app = appDao.findById(applicantId).get();
		
		job.setJobApplication(app);
		return jobDao.save(job);
	}

	public JobDtoOut getJob(long id) {
		Job j = jobDao.findById(id).get();
		return buildJobDto(j);
	}

	public void updateJob(Job job, long id) {
		Job j = jobDao.findById(id).get();

		j.setJobTitle(job.getJobTitle());
//		j.setJobApplication(job.getJobApplication());
		j.setCompany(job.getCompany());
		j.setRequiredSkill(job.getRequiredSkill());
		j.setPayScale(job.getPayScale());

		jobDao.save(j);

	}

	public void DeleteJob(long id) {
		jobDao.deleteById(id);
	}

}
