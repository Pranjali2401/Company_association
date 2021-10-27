package com.companyAssociation.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyAssociation.demo.dto.ApplicantDtoIn;
import com.companyAssociation.demo.dto.ApplicantDtoOut;
import com.companyAssociation.demo.model.Applicant;
import com.companyAssociation.demo.service.ApplicantService;

@RestController
@Validated
@RequestMapping("/applicant")
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;
	
	@PostMapping("/")
	public ResponseEntity<ApplicantDtoOut> addApplicant(@RequestBody @Valid ApplicantDtoIn applicant){
		return new ResponseEntity<ApplicantDtoOut>(applicantService.addApplicant(applicant),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApplicantDtoOut> getApplicant(@PathVariable long id){
		return new ResponseEntity<ApplicantDtoOut>(applicantService.getApplicant(id),HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateApplicant(@RequestBody Applicant applicant, @PathVariable long id){
		applicantService.updateApplicant(applicant, id);
		return new ResponseEntity<String>("Update Successfully !", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteApplicant(@PathVariable long id){
		applicantService.deleteApplicant(id);
		return new ResponseEntity<String>("Delete Successfylly !", HttpStatus.OK);
	}
	
}
