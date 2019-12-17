package com.progressoft.repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CurrencyRepository
{
    private final List<String> currencies;
    public CurrencyRepository () {
    	this.currencies = new ArrayList<String>();
    }
    
    public CurrencyRepository(final String currencies) {
        this.currencies = new ArrayList<String>(Arrays.asList(currencies.split(",")));
    }
    
    public List<String> findAll() {
        return new ArrayList<String>(this.currencies);
    }
    
    public boolean existByCode(final String code) {
        return this.currencies.contains(code);
    }
}