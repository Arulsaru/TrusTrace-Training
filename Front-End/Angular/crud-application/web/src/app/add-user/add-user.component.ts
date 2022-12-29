import { ResourceLoader } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FetchDataService } from '../fetch-data.service';
// import * as _ from 'lodash';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  ngOnInit(): void {
  }

  // firstName = new FormControl('', [Validators.required, Validators.nullValidator]);
  // lastName = new FormControl('', [Validators.required, Validators.nullValidator]);
  // phoneNumber = new FormControl('', [Validators.required, Validators.nullValidator]);
  
  firstName = new FormControl('', [Validators.required, Validators.pattern('^[A-Z][a-z]+$')]);
  lastName = new FormControl('', [Validators.required, Validators.pattern('^[A-Z][a-z]+$')]);
  phoneNumber = new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}')]);

  datas: Array<any> = [];
  isCreated: boolean = false;
  successMsg: string = '';

  getErrorMessage() {
    if (this.firstName.hasError('required')) {
      return 'You must enter a value';
    }
    return this.firstName.hasError('firstName') ? 'Not a valid First Name' : '';
  }

  createUser() {

    const newUserData = {
      // 'user_id': this.datas.length + 100,
      'first_name': this.firstName.value,
      'last_name': this.lastName.value,
      'phone_number': this.phoneNumber.value
    }

    if (!this.firstName.invalid && !this.lastName.invalid && !this.phoneNumber.invalid) {
      this.create.createData(newUserData).subscribe(
        result => {
          this.successMsg = Object.values(result)[0];
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: this.successMsg,
            showConfirmButton: true,
          }).then(result => {
            if(result.value) {
              tempRouter.navigate(['employees']);
            }
          })
        },
        errorMsg => {
          errorMsg = errorMsg.error.err;
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: errorMsg,
          })
        }
      );
      
      const tempRouter = this.route;
    }
  }

  constructor(private create: FetchDataService, private route: Router) {
    this.create.fetchData().subscribe((response) => {
      this.datas = response;
    });
  }
}