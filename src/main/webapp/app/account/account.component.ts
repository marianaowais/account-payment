import { Account } from './../models/account.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { AccountService } from './account.service';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styles: []
})
export class AccountComponent implements OnInit {

  accounts: Account[];
  account : Account ;

  constructor(private router: Router, private accountService: AccountService) {

  }

  ngOnInit() {
    this.accountService.getAccounts().subscribe( data => {
        this.accounts = data;
      },
      (res: HttpErrorResponse) => this.processError(res)
    );
  }

 getDetails(account: Account) { 
    this.accountService.accountDetails(account)
      .subscribe( data => {
        this.account =data ;
        this.router.navigate(['/account/' +account.id] ,{state: this.account});
      },
      (res: HttpErrorResponse) => this.processError(res)
    );
  }
 
  private processError(response: HttpErrorResponse) {
    if (response.status === 400 ) { // custom error
      alert("Account number already exist.");
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

