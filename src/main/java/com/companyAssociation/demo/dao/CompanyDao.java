package com.companyAssociation.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyAssociation.demo.model.Company;


public interface CompanyDao extends JpaRepository<Company,Long>{
	
}