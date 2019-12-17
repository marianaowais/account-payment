package com.progressoft.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progressoft.model.Account;


@Repository
@Transactional
public interface JpaAccountRepository extends JpaRepository<Account, String>
{
    boolean existsByAccountNumber(final Long accountNumber);

	
  
}