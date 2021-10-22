package com.companyAssociation.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.JobDao;
import com.companyAssociation.demo.model.Job;

@Service
public class JobService {

	@Autowired
	JobDao jobDao;

	public Job addJob(Job j) {
		Job job = jobDao.save(j);
		return job;
	}

	public Job getJob(long id) {
		return jobDao.findById(id).get();
	}

	public void updateJob(Job job, long id) {
		Job j = jobDao.findById(id).get();

		j.setJobTitle(job.getJobTitle());
		j.setJobApplication(job.getJobApplication());
		j.setCompany(job.getCompany());
		j.setRequiredSkill(job.getRequiredSkill());
		j.setPayScale(job.getPayScale());

		jobDao.save(j);

	}

	public void DeleteJob(long id) {
		jobDao.deleteById(id);
	}

}
