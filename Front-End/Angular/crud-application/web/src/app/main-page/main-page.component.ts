import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FetchDataService } from '../fetch-data.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})

export class MainPageComponent implements OnInit {

  ngOnInit(): void {
  }

  // itemsPerPage = new FormControl();

  page: number = 1;
  count: number = 6;
  datas: Array<any> = [];

  firstName: string = '';
  lastName: string = '';
  phoneNumber: number | null = null;
  msg: string = '';

  deleteUser(userId: number, firstName: string, lastName: string, phoneNumber: number) {

    const newData = {
      'user_id' : userId,
      'first_name': firstName,
      'last_name': lastName,
      'phone_number': phoneNumber
    }

    Swal.fire({
      title: 'Are you sure?',
      text: 'This will delete the entire details of the selected employee',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.deleteUser(newData, userId).subscribe(
          result => {
            console.log(result);
            this.msg = Object.values(result)[0];
            console.log(Object.values(result)[0]);
            console.log(this.msg);
          }
        );
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: this.msg,
          showConfirmButton: true,
        }).then((result) => {
          if(result.isConfirmed) {
            window.location.reload();
          }
        })
      }
    })
  }

  getOne() {
    const tempRouter = this.router;
    tempRouter.navigate(['employees/get-one']);
  }

  navigateEditUser(userId: number) {
    this.router.navigateByUrl('employees/update/' + userId);
  }
  
  constructor(private service: FetchDataService, private router: Router) {
      this.service.fetchData().subscribe(response => {
          this.datas = response;
        })
     }

}
