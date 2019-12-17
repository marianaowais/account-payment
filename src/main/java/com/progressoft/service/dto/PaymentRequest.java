package com.progressoft.service.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class PaymentRequest {
	@ApiModelProperty(required = true, value = "Source Account Number.")
	@NotNull(message = "Source Account Number must be filled")
	private Long sourceAccountNumber;
	
	@ApiModelProperty(required = true, value = "Destination Account Number, must be different than the Source Account Number.")
	@NotNull(message = "Destination Account Number must be filled")
	private Long destinationAccountNumber;
	
	@ApiModelProperty(required = true, value = "Amount, positive numeric value.")
	@NotNull(message = "Amount must be filled")
	@Min(value = 1L, message = "Amount must be positive value")
	private BigDecimal amount;
	
	@ApiModelProperty(required = true, value = "Currency Code, string value must be one of the currencies list values.")
	@NotBlank(message = "Currency Code must be filled")
	private String currencyCode;
	
	@ApiModelProperty("Payment Description, string value up to 1000 character.")
	private String paymentDescription;

	public Long getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(Long sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public Long getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(Long destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

}
