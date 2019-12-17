import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

import { Account } from '../models/account.model';
import { AccountService } from './account.service';
import { HttpErrorResponse } from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';


@Component({
  templateUrl: './add-account.component.html'
})
export class AddAccountComponent {

  account: Account ;
  @Input() public detailsView: boolean = false;
  
  constructor(private router: Router, private accountService: AccountService,private activatedroute: ActivatedRoute) {
    this.account= this.activatedroute.snapshot.params.id!=undefined ? this.router.getCurrentNavigation().extras.state as Account : new Account();
    this.detailsView= this.activatedroute.snapshot.params.id!=undefined? true :false;
  }

  ngOnInit() {
}

  createAccount() {
    this.accountService.createAccount(this.account)
        .subscribe( data => {
          alert("Account created successfully."); 
        // redirect to list 
        this.router.navigate(['/account']);

        },
          (res: HttpErrorResponse) => this.processError(res)
        );
  }

private processError(response: HttpErrorResponse) {
  if (response.status === 400 ) { // custom error (validation error for account number)
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
