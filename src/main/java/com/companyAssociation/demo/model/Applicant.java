package com.companyAssociation.demo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="applicant_table")
public class Applicant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="applicant_id")
	private long id;
	private String name;
	private String skills[];
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "jobApplications")
	private List<Job> appliedJob;

	public long getId() { 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public List<Job> getAppliedJob() {
		return appliedJob;
	}

	public void setAppliedJob(List<Job> appliedJob) {
		this.appliedJob = appliedJob;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(skills);
		result = prime * result + Objects.hash(appliedJob, id, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		return Objects.equals(appliedJob, other.appliedJob) && id == other.id && Objects.equals(name, other.name)
				&& Arrays.equals(skills, other.skills);
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", skills=" + Arrays.toString(skills) + ", appliedJob="
				+ appliedJob + "]";
	}
	
	

	
}
