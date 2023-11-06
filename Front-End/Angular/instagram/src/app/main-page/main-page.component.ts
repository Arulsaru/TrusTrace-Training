import { Component, OnInit } from '@angular/core';
import { userType } from '../interface/user-type';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css'],
})
export class MainPageComponent implements OnInit {
  userDatas: userType[] = [];
  token: String | null = sessionStorage.getItem("token");
  constructor(private service: UserService) {}

  ngOnInit(): void {
    // this.service.getUserById("swe").subscribe((res) => {
    //   console.log(res);
    // });

    this.service.generateToken().subscribe(res => {
      console.log(res);
    })

    // this.service.getUserByName("Swetha").subscribe((res) => {
    //   console.log(res);
    // });
    // this.service.getAllUsers().subscribe((res) => {
    //   console.log(res);
    // })
  }

}
