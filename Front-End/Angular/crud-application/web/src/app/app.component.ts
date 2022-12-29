import { Component } from '@angular/core';
import { FetchDataService } from './fetch-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  p: number = 1;
  count: number = 10;

  element: boolean = true;
  
  datas: Array<any> = [];
  
  constructor() {}

}
