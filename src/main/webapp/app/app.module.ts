import { AddPaymentComponent } from './payment/add-payment.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentService } from './payment/payment.service';
import { AccountService } from './account/account.service';
import { AddAccountComponent } from './account/add-account.component';
import { AccountComponent } from './account/account.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    AddAccountComponent,
    PaymentComponent, 
    AddPaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PaymentService, AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
