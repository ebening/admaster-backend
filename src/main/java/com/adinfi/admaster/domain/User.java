package com.adinfi.admaster.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "APP_USER")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", length = 50, unique = true)
	@NotNull
	@Size(min = 4, max = 50)
	private String username;

	@Column(name = "PASSWORD", length = 100)
	@NotNull
	@Size(min = 4, max = 100)
	private String password;

	@Column(name = "FIRSTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String firstname;

	@Column(name = "FATHERLASTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String fatherLastName;
	
	@Column(name = "MOTHERLASTNAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String motherLastName;

	@Column(name = "EMAIL", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String email;

	@Column(name = "ACTIVE")
	@NotNull
	private Boolean active;

	@Column(name = "LASTPASSWORDRESETDATE")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastPasswordResetDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_PROFILE", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID") })
	
	private List<Profile> profiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}
