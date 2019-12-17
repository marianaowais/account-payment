package com.progressoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progressoft.repository.CurrencyRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/currency" })
@Api("Currency API , List only")
public class CurrencyController
{
   @Autowired
    private CurrencyRepository currencyRepository;
   
   
   public CurrencyController(CurrencyRepository currencyRepository) {
       this.currencyRepository = currencyRepository;
   }
    @GetMapping
    @CrossOrigin({ "*" })
    @ApiOperation("Method To List All Currencies")
    public ResponseEntity<List<String>> listCurrencies() {
        return ResponseEntity.of((Optional)Optional.of(this.currencyRepository.findAll()));
    }
}