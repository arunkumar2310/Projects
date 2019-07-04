package com.training.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wishes")
public class Wish implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -847928819595877397L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Num;

	@Column(name = "wishedTo")
	private String wishedTo;

	@Column(name = "wishMessage")
	private String wishMessage;

	@Column(name = "wishedBy")
	private String wishedBy;

    @Column(name = "wishesTo_UserId")
    private String wishedToUserId;
    
	public Long getNum() {
		return Num;
	}

	public void setNum(Long num) {
		Num = num;
	}

	public String getWishedTo() {
		return wishedTo;
	}

	public void setWishedTo(String wishedTo) {
		this.wishedTo = wishedTo;
	}

	public String getWishMessage() {
		return wishMessage;
	}

	public void setWishMessage(String wishMessage) {
		this.wishMessage = wishMessage;
	}

	public String getWishedBy() {
		return wishedBy;
	}

	public void setWishedBy(String wishedBy) {
		this.wishedBy = wishedBy;
	}

	public String getWishedToUserId() {
		return wishedToUserId;
	}

	public void setWishedToUserId(String wishedUserToId) {
		this.wishedToUserId = wishedUserToId;
	}


	@Override
	public String toString(){
		return "Wish [S.no="+Num+"wishedTo=" + wishedTo + ",wishMessage=" + wishMessage + ",wishedBy=" + wishedBy + ",wishedToUserId=" + wishedToUserId +"]";
	}
}
