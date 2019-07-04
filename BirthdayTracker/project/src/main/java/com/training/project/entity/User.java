package com.training.project.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{


	private static final long serialVersionUID = 1212422864977687649L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name="date")
	private String date;
	
	@Column(name="month")
	private String month;

	@Column(name = "mobile")
	private Long mobile;

	@Column(name = "cakes")
	private String cakes;

	@Column(name = "colour")
	private String colour;

	@Column(name = "about")
	private String about;

	@Column(name = "password")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getCakes() {
		return cakes;
	}

	public void setCakes(String cakes) {
		this.cakes = cakes;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", dateOfBirth=" + dateOfBirth + ",date="+date+ ",month="+month+ ", name=" + name +  ", mobile=" + mobile
				+ ", cakes=" + cakes + ", colour=" + colour + ", about=" + about + ", password=" + password + "]";
	}

}
