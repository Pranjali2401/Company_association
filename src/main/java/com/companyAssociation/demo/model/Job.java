package com.companyAssociation.demo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_table")
public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="job_id")
	private long id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="required_skill")
	private String requiredSkill[];
	
	@Column(name="payscale")
	private long payScale;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Company company;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="job_application",
			joinColumns = @JoinColumn(name="job_id"),
			inverseJoinColumns = @JoinColumn(name="applicant_id")
			)
	private Set<Applicant> jobApplications = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String[] getRequiredSkill() {
		return requiredSkill;
	}

	public void setRequiredSkill(String[] requiredSkill) {
		this.requiredSkill = requiredSkill;
	}

	public long getPayScale() {
		return payScale;
	}

	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Applicant> getJobApplication() {
		return jobApplications;
	}

	public void setJobApplication(Applicant jobApplication) {
		jobApplications.add(jobApplication);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(requiredSkill);
		result = prime * result + Objects.hash(company, id, jobApplications, jobTitle, payScale);
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
		Job other = (Job) obj;
		return Objects.equals(company, other.company) && id == other.id
				&& Objects.equals(jobApplications, other.jobApplications) && Objects.equals(jobTitle, other.jobTitle)
				&& payScale == other.payScale && Arrays.equals(requiredSkill, other.requiredSkill);
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", requiredSkill=" + Arrays.toString(requiredSkill)
				+ ", payScale=" + payScale + ", company=" + company + ", jobApplications=" + jobApplications + "]";
	}


}
