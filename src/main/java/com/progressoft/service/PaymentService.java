package com.progressoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progressoft.model.Payment;
import com.progressoft.repository.JpaPaymentRepository;
import com.progressoft.service.dto.PaymentRequest;
import com.progressoft.service.validation.PaymentValidation;
import com.progressoft.service.validation.ValidationException;

@Service
public class PaymentService
{
	@Autowired
    private final JpaPaymentRepository paymentRepository;
    
	@Autowired
	private final PaymentValidation paymentValidation;
    
    public PaymentService(final JpaPaymentRepository paymentRepository, final PaymentValidation paymentValidation) {
        this.paymentRepository = paymentRepository;
        this.paymentValidation = paymentValidation;
    }
    
    public Payment addPayment(final PaymentRequest paymentRequest) {
        this.paymentValidation.validatePaymentRequest(paymentRequest);
        return (Payment)this.paymentRepository.save(this.toPayment(paymentRequest));
    }
    
    public Payment getPayment(final String id) {
        final Optional<Payment> payment = (Optional<Payment>)this.paymentRepository.findById(id);
        if (payment.equals(null)) {
            throw new ValidationException(id.toString());
        }
        return payment.get();
    }
    
    public List<Payment> getAllPayments() {
        return (List<Payment>)this.paymentRepository.findAll();
    }
    
    private Payment toPayment(final PaymentRequest paymentRequest) {
        final Payment payment = new Payment();
        payment.setSourceAccountNumber(paymentRequest.getSourceAccountNumber());
        payment.setDestinationAccountNumber(paymentRequest.getDestinationAccountNumber());
        payment.setAmount(paymentRequest.getAmount());
        payment.setCurrencyCode(paymentRequest.getCurrencyCode());
        payment.setPaymentDescription(paymentRequest.getPaymentDescription());
        return payment;
    }
}