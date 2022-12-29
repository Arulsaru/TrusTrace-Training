import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { FetchDataService } from '../fetch-data.service';

@Component({
  selector: 'app-get-one',
  templateUrl: './get-one.component.html',
  styleUrls: ['./get-one.component.css']
})
export class GetOneComponent implements OnInit {

  ngOnInit(): void {
  }

  datas: Array<any> = [];
  userId = new FormControl('', Validators.required);
  // const id = parseInt(this.userId.value);

  getOne() {
    console.log(typeof this.userId.value); 

    // this.service.getOne(112).subscribe( response => {
    //   const getOneData = response;
    //   console.log(getOneData);
    // });
  } 

  constructor(private service: FetchDataService) {
    this.service.fetchData().subscribe(response => {
      this.datas = response;
    })
   }

}
