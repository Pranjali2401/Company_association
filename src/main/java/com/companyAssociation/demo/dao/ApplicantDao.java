package com.companyAssociation.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyAssociation.demo.model.Applicant;

public interface ApplicantDao extends JpaRepository<Applicant, Long> {

}
