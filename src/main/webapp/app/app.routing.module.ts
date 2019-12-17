import { AddAccountComponent } from './account/add-account.component';
import { AccountComponent } from './account/account.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { Account } from './models/account.model';
import { AddPaymentComponent } from './payment/add-payment.component';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
  { path: 'account', component: AccountComponent },
  { path: 'account/add', component: AddAccountComponent },
  { path: 'account/:id', component: AddAccountComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'payment/add', component: AddPaymentComponent },
  { path: 'payment/:id', component: AddPaymentComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
