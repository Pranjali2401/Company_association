package com.companyAssociation.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manager_hr_table")
public class ManagerHr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "manager_id")
	private long id;

	@Column(name = "manager_name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL , mappedBy = "managerHr")
	private Company company;

	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerHr other = (ManagerHr) obj;
		return Objects.equals(company, other.company) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ManagerHr [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

}
