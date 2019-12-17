import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Payment } from '../models/payment.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PaymentService {

  constructor(private http:HttpClient) {}

  private paymentUrl = 'http://localhost:8080/payments-system/payment';
  

  public getPayments() {
    return this.http.get<Payment[]>(this.paymentUrl);
  }

  public paymentDetails(payment) { 
    return this.http.get<Payment>(this.paymentUrl + "/"+ payment.id );
  }

  public createPayment(payment) {
    debugger ;
    return this.http.post<Payment>(this.paymentUrl+"/add", payment);
  }

}
