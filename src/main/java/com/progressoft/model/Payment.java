package com.progressoft.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Payment
{
	//@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
    
    @Column(nullable = false)
    private Long sourceAccountNumber;
    
    @Column(nullable = false)
    private Long destinationAccountNumber;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
    private String currencyCode;
    
    @Column(length = 1000)
    private String paymentDescription;
    
    public String getId() {
        return this.id;
    }
    
    public Long getSourceAccountNumber() {
        return this.sourceAccountNumber;
    }
    
    public Long getDestinationAccountNumber() {
        return this.destinationAccountNumber;
    }
    
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public String getCurrencyCode() {
        return this.currencyCode;
    }
    
    public String getPaymentDescription() {
        return this.paymentDescription;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setSourceAccountNumber(final Long sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }
    
    public void setDestinationAccountNumber(final Long destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }
    
    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }
    
    public void setCurrencyCode(final String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public void setPaymentDescription(final String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }
    
    public Payment() {
    }
    
    public Payment(final String id, final Long sourceAccountNumber, final Long destinationAccountNumber, final BigDecimal amount, final String currencyCode, final String paymentDescription) {
        this.id = id;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.paymentDescription = paymentDescription;
    }
}