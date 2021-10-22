package com.companyAssociation.demo.controller;

import java.util.List;

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

import com.companyAssociation.demo.model.ManagerHr;
import com.companyAssociation.demo.service.ManagerHrService;

@RestController
@RequestMapping(value = "/manager")
public class ManagerHrController {

	@Autowired
	ManagerHrService managerHrService;

	@PostMapping("/")
	public ResponseEntity<ManagerHr> addManaherHr(@RequestBody ManagerHr mh) {
		return new ResponseEntity<ManagerHr>(managerHrService.addManagerHr(mh), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<ManagerHr>> getAllManager() {
		return new ResponseEntity<List<ManagerHr>>(managerHrService.getAllManagerHr(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ManagerHr> getManagerHr(@PathVariable long id) {
		return new ResponseEntity<ManagerHr>(managerHrService.getManagerHr(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateManagerHr(@RequestBody ManagerHr managerHr, @PathVariable long id) {
		managerHrService.updateManagerHr(managerHr, id);
		return new ResponseEntity<String>("Update Successfully !", HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteManagerHr(@PathVariable long id){
		managerHrService.deleteManagerHr(id);
		return new ResponseEntity<String>("Delete Successfully!", HttpStatus.OK);
	}
	
}
