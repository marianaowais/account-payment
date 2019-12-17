package com.progressoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.progressoft.model.Payment;


@Repository
@Transactional
public interface JpaPaymentRepository extends JpaRepository<Payment, String>
{


}