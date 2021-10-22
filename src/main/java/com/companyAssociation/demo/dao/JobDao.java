package com.companyAssociation.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyAssociation.demo.model.Job;

public interface JobDao extends JpaRepository<Job, Long> {

}
