import { Account } from './../models/account.model';
import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';




const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AccountService {

  constructor(private http:HttpClient) {}

  private accountUrl = 'http://localhost:8080/payments-system/account';
 

  public getAccounts() {
    return this.http.get<Account[]>(this.accountUrl);
  }

  public accountDetails(account) { 
    return this.http.get<Account>(this.accountUrl + "/"+ account.id );
  }

  public createAccount(account) {
    return this.http.post<Account>(this.accountUrl+"/add", account);
  }

}
