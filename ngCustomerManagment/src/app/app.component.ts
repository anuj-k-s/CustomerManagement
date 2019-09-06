import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  getUrl = 'http://localhost:8080/techsera/customer';
  customers: any;
  errorAlert: boolean;
  successAlert: boolean;
  error_message: string;
  success_message: string;
  constructor(private http: HttpClient) {
    this.customers = [];
    this.getAllCustomers();
  }
  customerForm: FormGroup;
  ngOnInit() {
    this.customerForm = new FormGroup({
      firstName: new FormControl(),
      lastName: new FormControl(),
      address: new FormControl(),
      email: new FormControl(),
      contactNo: new FormControl()

    });

  }
  getAllCustomers() {
    debugger;
    this.http.get(this.getUrl).subscribe(
      data => {
        this.customers = data;
      },
      error => {
        debugger;
        this.errorAlert = true;
        this.successAlert = false;
        this.error_message = error.error.message ? error.error.message : error.statusText;
      });
  }

  addNewCustomer() {
    this.http.post(this.getUrl, this.customerForm.value).subscribe(
      data => {
        this.errorAlert = false;
        this.successAlert = true;
        this.customers.push(data);
        this.success_message = 'Customer is added successfully';
      },
      error => {
        this.errorAlert = true;
        this.successAlert = false;
        console.log(error);
        this.error_message = error.error.message;
      });
  }

  deleteCustomerById(customer) {
    debugger;
    this.http.delete(this.getUrl + '/' + customer.customerId).subscribe(
      data => {
        this.errorAlert = false;
        this.successAlert = true;
       this.customers = this.customers.filter(cus => cus != customer);
        this.success_message = 'Customer is deleted successfully';
      },
      error => {
        this.errorAlert = true;
        this.successAlert = false;
        console.log(error);
        this.error_message = error.error.message;
      });
    console.log(customer);
  }

}
