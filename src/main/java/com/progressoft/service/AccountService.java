package com.progressoft.service ;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progressoft.model.Account;
import com.progressoft.repository.JpaAccountRepository;
import com.progressoft.service.dto.AccountRequest;
import com.progressoft.service.validation.AccountValidation;
import com.progressoft.service.validation.ValidationException;
@Service
public class AccountService
{
	@Autowired
    private final JpaAccountRepository accountRepository;
    
	@Autowired
    private final AccountValidation accountValidation;
    
    public AccountService(final JpaAccountRepository accountRepository, final AccountValidation accountValidation) {
        this.accountRepository = accountRepository;
        this.accountValidation = accountValidation;
    }
    
    public Account addAccount(final AccountRequest accountRequest) {
        this.accountValidation.validateAccountRequest(accountRequest);
        return (Account)this.accountRepository.save(this.toAccount(accountRequest));
    }
    
    public Account getAccount(final String id) {
        final Optional<Account> account = (Optional<Account>)this.accountRepository.findById(id);
        if (account.equals(null)) {
            throw new ValidationException(id.toString());
        }
        return account.get();
    }
    
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }
    
    private Account toAccount(final AccountRequest accountRequest) {
        final Account account = new Account();
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setAccountHolderName(accountRequest.getAccountHolderName());
        account.setAccountHolderPhoneNumber(accountRequest.getAccountHolderPhoneNumber());
        account.setAccountDescription(accountRequest.getAccountDescription());
        return account;
    }
}