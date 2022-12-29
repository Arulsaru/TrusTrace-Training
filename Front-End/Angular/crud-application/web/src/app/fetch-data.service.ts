import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FetchDataService {
  
  constructor(private _http:HttpClient) { }

  id: number = 0;
  firstName: string = '';
  lastName: string = '';
  phoneNumber: number = 0;

  baseURL: string = 'http://localhost:8000/employees/';

  fetchData():Observable <any> {
    return this._http.get(this.baseURL);
  }

  createData(newUserData: object) {
    return this._http.post(this.baseURL + 'create', newUserData);
  }

  updateUser(datas: object, userId: number) {
    return this._http.put<object>(this.baseURL + userId + '/update/', datas);
  }

  deleteUser(data: object, userId: number){
    // return this._http.delete<object>('http://localhost:8000/delete?user_id=' + userId);
    return this._http.delete<object>(this.baseURL + userId + '/delete', data);
  }

  getOne(userId: number) {
    return this._http.get(this.baseURL + 'getone/' + userId );
  }

  setId(userId: number) {
    this.id = userId;
  } 

  setDetails(firstName: string, lastName: string, phoneNumber: number) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  getFirstName() {
    return this.firstName;
  }

  getLastName() {
    return this.lastName;
  }

  getPhoneNumber() {
    return this.phoneNumber;
  }

  getId() {
    return this.id;
  }

}
