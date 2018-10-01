import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { DataRecord } from '../domain/dataRecord';

@Injectable({
  providedIn: 'root'
})
export class GenericService {
	private restUrl = 'http://localhost:8080/orx-web/api/rs/user/list';
	
	constructor(
		private httpClient: HttpClient
	) { }
  
	readList<T extends DataRecord>(): Observable<T[]> {
		return this.httpClient.get<T[]>(this.restUrl);
	}  
}
