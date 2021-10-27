package com.companyAssociation.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyAssociation.demo.dto.JobDtoIn;
import com.companyAssociation.demo.dto.JobDtoOut;
import com.companyAssociation.demo.model.Job;
import com.companyAssociation.demo.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	JobService jobService;

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<JobDtoOut> addJob(@Valid @RequestBody JobDtoIn job) {
		return new ResponseEntity<JobDtoOut>(jobService.addJob(job), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobDtoOut> getJob(@PathVariable long id) {
		return new ResponseEntity<JobDtoOut>(jobService.getJob(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable long id) {
		jobService.updateJob(job, id);
		return new ResponseEntity<String>("Update Job Successfully !", HttpStatus.OK);
	}
	@PutMapping("/{jId}/company/{cId}")
	public ResponseEntity<Job> addCompany(@PathVariable long jId,@PathVariable long cId){
		return new ResponseEntity<Job>(jobService.addCompany(jId, cId),HttpStatus.CREATED);
	}

	@PutMapping("/{jId}/applicant/{aId}")
	public ResponseEntity<Job> addApplicant(@PathVariable long jId, @PathVariable long aId){
		return new ResponseEntity<Job>(jobService.addApplicant(jId, aId), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable long id) {
		jobService.DeleteJob(id);
		return new ResponseEntity<String>("Deleted Job", HttpStatus.OK);
	}
}
