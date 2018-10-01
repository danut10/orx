import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { DataRecord } from '../domain/dataRecord';

@Injectable({
  providedIn: 'root'
})
export class GenericService {
	private baseUrl = 'http://localhost:8080/orx-web/api/rs/user';
	
	constructor(
		private httpClient: HttpClient
	) { }
  
	readList<T extends DataRecord>(): Observable<T[]> {
		const url = this.baseUrl;
		return this.httpClient.get<T[]>(url);
	}  
	
	read<T extends DataRecord>(id: number): Observable<T> {
		const url = this.baseUrl + "/" + id;
		return this.httpClient.get<T>(url);
	}  
	
}
