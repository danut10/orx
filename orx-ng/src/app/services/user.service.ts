import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../domain/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
	private restUrl = 'http://localhost:8080/orx-web/api/rs/user/list';
	
	constructor(
		private httpClient: HttpClient	
	) { }
  
	readList(): Observable<User[]> {
		return this.httpClient.get<User[]>(this.restUrl);
	}

}