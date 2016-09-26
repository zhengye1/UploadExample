package com.uploadExample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPUSER")
public class AppUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919603900824482889L;

	@Id @Column(name="ID") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="username")
	private String username;

	@Column(name="hasProfileImage")
	private Integer hasProfileImage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getHasProfileImage() {
		return hasProfileImage;
	}

	public void setHasProfileImage(Integer hasProfileImage) {
		this.hasProfileImage = hasProfileImage;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", hasProfileImage=" + hasProfileImage + "]";
	}
}
