package com.progressoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Account {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(nullable = false, unique = true)
	private Long accountNumber;
	
	@Column(nullable = false)
	private String accountHolderName;
	
	@Column
	private String accountHolderPhoneNumber;
	
	@Column(length = 1000)
	private String accountDescription;

	public String getId() {
		return this.id;
	}

	public Long getAccountNumber() {
		return this.accountNumber;
	}

	public String getAccountHolderName() {
		return this.accountHolderName;
	}

	public String getAccountHolderPhoneNumber() {
		return this.accountHolderPhoneNumber;
	}

	public String getAccountDescription() {
		return this.accountDescription;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setAccountNumber(final Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountHolderName(final String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountHolderPhoneNumber(final String accountHolderPhoneNumber) {
		this.accountHolderPhoneNumber = accountHolderPhoneNumber;
	}

	public void setAccountDescription(final String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public Account() {
	}

	public Account(final String id, final Long accountNumber, final String accountHolderName,
			final String accountHolderPhoneNumber, final String accountDescription) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountHolderPhoneNumber = accountHolderPhoneNumber;
		this.accountDescription = accountDescription;
	}
}