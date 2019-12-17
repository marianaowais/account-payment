package com.progressoft.service.validation;


import java.util.Set;
import javax.validation.Validator;

import org.springframework.stereotype.Component;

import com.progressoft.repository.JpaAccountRepository;
import com.progressoft.service.dto.AccountRequest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import com.progressoft.service.validation.ValidationException;




@Component
public class AccountValidation
{
    private final JpaAccountRepository accountRepository;
    
    public AccountValidation(final JpaAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public void validateAccountRequest(final AccountRequest accountRequest) {
        this.validateRequestModel(accountRequest);
        this.validateAccountNumberUnique(accountRequest.getAccountNumber());
    }
    
    private void validateAccountNumberUnique(final Long accountNumber) {
        if (this.accountRepository.existsByAccountNumber(accountNumber)) {
            throw new ValidationException(accountNumber.toString()); 
        }
    }
    
    private void validateRequestModel(final AccountRequest accountRequest) {
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<AccountRequest>> violations =(Set<ConstraintViolation<AccountRequest>>)validator.validate(accountRequest, new Class[0]);
        		
        if (!violations.isEmpty()) {
            throw new ValidationException(violations.iterator().next().getMessage());
        }
    }
}