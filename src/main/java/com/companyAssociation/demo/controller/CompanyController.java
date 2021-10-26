package com.companyAssociation.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyAssociation.demo.dto.CompanyDtoIn;
import com.companyAssociation.demo.dto.CompanyDtoOut;
import com.companyAssociation.demo.model.Company;
import com.companyAssociation.demo.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("/")
	public ResponseEntity<CompanyDtoOut> addCompany(@RequestBody @Valid CompanyDtoIn company) {
		return new ResponseEntity<CompanyDtoOut>(companyService.addCompany(company), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDtoOut> getCompany(@PathVariable long id) {
		return new ResponseEntity<CompanyDtoOut>(companyService.getCompany(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company,@PathVariable long id){
		companyService.updateCompany(company, id);
		return new ResponseEntity<String>("Update Company details", HttpStatus.OK);
	}
	
	@PutMapping("/{cid}/managerhr/{mid}")
	public ResponseEntity<Company> addManagerIntoCompany(@PathVariable long cid,@PathVariable long mid){
		return new ResponseEntity<Company>(companyService.addManager(cid, mid), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable long id){
		companyService.deleteCompany(id);
		return new ResponseEntity<String>("Delete Company details", HttpStatus.OK);
	}
}
