import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from 'app/models/payment.model';
import { PaymentService } from './payment.service';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styles: []
})
export class PaymentComponent implements OnInit {

  payments: Payment[];
  payment: Payment;
  constructor(private router: Router, private paymentService: PaymentService) {

  }

  ngOnInit() {
    this.paymentService.getPayments()
      .subscribe( data => {
        this.payments = data;
      });
  };

  getDetails(payment: Account) { 
    this.paymentService.paymentDetails(payment)
      .subscribe( data => {
        this.payment =data ;
        this.router.navigate(['/payment/' +payment.id] ,{state: this.payment});
      },
      (res: HttpErrorResponse) => this.processError(res)
    );
  }

private processError(response: HttpErrorResponse) {
  if (response.status === 400 ) { // custom error
    alert("Destination/Source Account Not Exist");
  }
  if (response.status === 403 ) {
    alert("Forbidden to access this page.");
  }
  if (response.status === 401 ) {
    alert("You are not authorized to access this page.");
  }
  if (response.status === 405 ) {
    alert("The HTTP verb you used is not supported for this URL.");
  }
  if (response.status === 500 ) { // 404 
    alert("Internal server error.");
  }
  if (response.status === 500 ) { 
    alert("Not found.");
  }
 
}

}