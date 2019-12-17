import { Component, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Payment } from 'app/models/payment.model';
import { PaymentService } from './payment.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  templateUrl: './add-payment.component.html'
})
export class AddPaymentComponent {

  payment: Payment = new Payment();
  @Input() public detailsView: boolean = false;

  constructor(private router: Router, private paymentService: PaymentService,private activatedroute: ActivatedRoute) {
    this.payment= this.activatedroute.snapshot.params.id!=undefined ? this.router.getCurrentNavigation().extras.state as Payment : new Payment();
    this.detailsView= this.activatedroute.snapshot.params.id!=undefined? true :false;
  }

  createPayment(): void {
    debugger ;
    this.paymentService.createPayment(this.payment)
        .subscribe( data => {
          alert("Payment created successfully.");
          this.router.navigate(['/payment']);

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
