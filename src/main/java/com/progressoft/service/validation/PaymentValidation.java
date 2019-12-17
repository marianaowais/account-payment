package com.progressoft.service.validation;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.progressoft.repository.JpaAccountRepository;
import com.progressoft.service.dto.PaymentRequest;

@Component
public class PaymentValidation
{
	@Autowired
    private final JpaAccountRepository accountRepository;
   

    public PaymentValidation(final JpaAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
  
    }
    
    public void validatePaymentRequest(final PaymentRequest paymentRequest) {
        this.validateRequestModel(paymentRequest);
        this.validateAccountNumberExist(paymentRequest.getSourceAccountNumber(), "Source Account Not Exist");
        this.validateAccountNumberExist(paymentRequest.getDestinationAccountNumber(), "Destination Account Not Exist");
        this.validateSourceAndDestinationNotTheSame(paymentRequest);
 
    }
    
    
    private void validateSourceAndDestinationNotTheSame(final PaymentRequest paymentRequest) {
        if (paymentRequest.getSourceAccountNumber().equals(paymentRequest.getDestinationAccountNumber())) {
            throw new ValidationException("Source and Destination Accounts must not be the same");
        }
    }
    
    private void validateAccountNumberExist(final Long accountNumber, final String message) {
        if (!this.accountRepository.existsByAccountNumber(accountNumber)) {
            throw new ValidationException(message);
        }
    }
    
    private void validateRequestModel(final PaymentRequest paymentRequest) {
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<PaymentRequest>> violations = 
        		(Set<ConstraintViolation<PaymentRequest>>)validator.validate(paymentRequest, new Class[0]);
        if (!violations.isEmpty()) {
            throw new ValidationException(violations.iterator().next().getMessage());
        }
    }
}