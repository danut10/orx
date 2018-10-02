import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserFilter } from '../domain/userFilter';

import { DataRecord } from '../domain/dataRecord';

@Injectable({
  providedIn: 'root'
})
export class GenericService {
	private baseUrl = 'http://localhost:8080/orx-web/api/rs';
	
	constructor(
		private httpClient: HttpClient
	) { }
  
	list<T extends DataRecord>(entityCode: string): Observable<T[]> {
		const url = this.baseUrl + "/" + entityCode;
		return this.httpClient.get<T[]>(url);
	}  

	listFilter<T extends DataRecord>(entityCode: string, filter: UserFilter): Observable<T[]> {
		const url = this.baseUrl + "/" + entityCode + "/filter";
		return this.httpClient.post<T[]>(url, filter);
	}  
	
	
	read<T extends DataRecord>(entityCode: string, id: number): Observable<T> {
		const url = this.baseUrl + "/" + entityCode + "/" + id;
		return this.httpClient.get<T>(url);
	}  
	
}
