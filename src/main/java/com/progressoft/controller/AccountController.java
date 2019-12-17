package com.progressoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progressoft.model.Account;
import com.progressoft.service.AccountService;
import com.progressoft.service.dto.AccountRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping({ "account" })
@Api("Account API , Add/Get By Id/List")
@EnableSwagger2
public class AccountController
{
	@Autowired
    private final AccountService accountService;
    
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping
    @CrossOrigin({ "*" })
    @ApiOperation("Method To List All Accounts")
    public ResponseEntity<List<Account>> listAccounts() {
        return  ResponseEntity.of((Optional)Optional.of(this.accountService.getAllAccounts()));
    }
    
    @PostMapping({ "/add" })
    @CrossOrigin({ "*" })
    @ApiOperation("Method To Add Account")
    public ResponseEntity<Account> addAccount(@RequestBody final AccountRequest accountRequest) {
        return ResponseEntity.of((Optional)Optional.of(this.accountService.addAccount(accountRequest)));
    }
    
    @GetMapping({ "/{id}" })
    @CrossOrigin({ "*" })
    @ApiOperation("Method To Get Account By Id")
    public ResponseEntity<Account> getAccount(@PathVariable("id") final String id) {
        return ResponseEntity.of((Optional)Optional.of(this.accountService.getAccount(id)));
    }
}