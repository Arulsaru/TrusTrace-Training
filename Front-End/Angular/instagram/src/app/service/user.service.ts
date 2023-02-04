import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { userType } from "../interface/user-type";

@Injectable({
    providedIn: 'root'
})

export class UserService {
    baseURL: string = 'http://localhost:8090/user';

    constructor( private http: HttpClient ) {}

    getAllUsers(): Observable<userType[]> {
        return this.http.get<userType[]>(`${this.baseURL}/getAllUsers`);
    }

    getUserById(userId: String): Observable<Object> {
        return this.http.get(`${this.baseURL}/id/${userId}`);
    }

    getUserByName(userName: String): Observable<Object> {
        return this.http.get(`${this.baseURL}/name/${userName}`);
    }
    deleteUser(userId: String): Observable<Object> {
        return this.http.delete(`${this.baseURL}/id/${userId}`);
    }
}