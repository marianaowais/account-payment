package com.progressoft.service.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class AccountRequest {

	@ApiModelProperty(required = true, value = "Account Number, 6 digits number and unique.")
	@NotNull(message = "Account Number must be filled")
	@Min(value = 100000L, message = "Account Number must contain 6 digits")
	@Max(value = 999999L, message = "Account Number must contain 6 digits")
	private Long accountNumber;

	@ApiModelProperty(required = true, value = "Account Holder Name, string value.")
	@NotBlank(message = "Account Holder Name must be filled")
	private String accountHolderName;

	@ApiModelProperty("Account Holder Phone Number, string value.")
	private String accountHolderPhoneNumber;

	@ApiModelProperty("Account Description, string value up to 1000 character.")
	private String accountDescription;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderPhoneNumber() {
		return accountHolderPhoneNumber;
	}

	public void setAccountHolderPhoneNumber(String accountHolderPhoneNumber) {
		this.accountHolderPhoneNumber = accountHolderPhoneNumber;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

}