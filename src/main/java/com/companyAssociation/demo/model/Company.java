package com.companyAssociation.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company_table")
public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="company_id")
	private long id;
	
	@Column(name="company_name")
	private String name;
	
	@Column(name="start_date")
	private Date startedDate;
	
	private String domain;
	
	@OneToMany(mappedBy = "company")
	private List<Job> openJobs;
	
	@OneToOne
	@JoinColumn(name="manager_id")
	private ManagerHr managerHr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<Job> getOpenJobs() {
		return openJobs;
	}

	public void setOpenJobs(List<Job> openJobs) {
		this.openJobs = openJobs;
	}

	public ManagerHr getManagerHr() {
		return managerHr;
	}

	public void setManagerHr(ManagerHr managerHr) {
		this.managerHr = managerHr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, id, managerHr, name, openJobs, startedDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(domain, other.domain) && id == other.id && Objects.equals(managerHr, other.managerHr)
				&& Objects.equals(name, other.name) && Objects.equals(openJobs, other.openJobs)
				&& Objects.equals(startedDate, other.startedDate);
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", startedDate=" + startedDate + ", domain=" + domain
				+ ", openJobs=" + openJobs + ", managerHr=" + managerHr + "]";
	}
	
	
	
}
