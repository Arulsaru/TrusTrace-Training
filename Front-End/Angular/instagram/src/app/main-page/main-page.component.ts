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
  constructor(private service: UserService) {}

  ngOnInit(): void {
    this.service.getAllUsers().subscribe((res: userType[]) => {
      this.userDatas = res;
    });
  }

}
