package com.progressoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progressoft.model.Payment;
import com.progressoft.service.PaymentService;
import com.progressoft.service.dto.PaymentRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/payment" })
@Api("Payment API , Add/Get By Id/List")
public class PaymentController
{
	@Autowired
    private final PaymentService paymentService;
    
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    @GetMapping
    @CrossOrigin({ "*" })
    @ApiOperation("Method To List All Payments")
    public ResponseEntity<List<Payment>> listPayments() {
        return (ResponseEntity<List<Payment>>)ResponseEntity.of((Optional)Optional.of(this.paymentService.getAllPayments()));
    }
    
    @PostMapping({ "/add" })
    @CrossOrigin({ "*" })
    @ApiOperation("Method To Add Payment")
    public ResponseEntity<Payment> addPayment(@RequestBody final PaymentRequest paymentRequest) {
        return (ResponseEntity<Payment>)ResponseEntity.of((Optional)Optional.of(this.paymentService.addPayment(paymentRequest)));
    }
    
    @GetMapping({ "/{id}" })
    @CrossOrigin({ "*" })
    @ApiOperation("Method To Get Payment By Id")
    public ResponseEntity<Payment> getPayment(@PathVariable("id") final String id) {
        return (ResponseEntity<Payment>)ResponseEntity.of((Optional)Optional.of(this.paymentService.getPayment(id)));
    }
}