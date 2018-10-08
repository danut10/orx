import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { DataRecord, Pager, Sorter } from '../domain/core';

@Injectable({
  providedIn: 'root'
})
export class GenericService {
	private baseUrl = 'http://localhost:8080/orx-web/api/rs';
	
	constructor(
		private httpClient: HttpClient
	) { }
  
	// Methods - Query
	
	read<T extends DataRecord>(entityCode: string, id: number): Observable<T> {
		const url = this.baseUrl + "/" + entityCode + "/" + id;
		return this.httpClient.get<T>(url);
	}  

	readList<T extends DataRecord>(entityCode: string): Observable<T[]> {
		const url = this.baseUrl + "/" + entityCode;
		return this.httpClient.get<T[]>(url);
	}  

	browse<T extends DataRecord>(entityCode: string, filter?, sorter?: Sorter, pager?: Pager): Observable<T[]> {
		if (!filter) { filter = {} };
		let url = `${this.baseUrl}/${entityCode}/browse`;
		if (sorter && sorter.field) { url += ";sorterField=" + sorter.field; }
		if (sorter && sorter.desc) { url += ";sorterDesc"; }
		if (pager && pager.pageSize) { url += ";pageSize=" + pager.pageSize; }
		if (pager && pager.pageNo) { url += ";pageNo=" + pager.pageNo; }
		return this.httpClient.post<T[]>(url, filter);
	}  
	
	// Methods - Command
	
	create<T extends DataRecord>(entityCode: string, record: T): Observable<number> {
		const url = this.baseUrl + "/" + entityCode;
		return this.httpClient.post<number>(url, record);
	}  	
		
	update<T extends DataRecord>(entityCode: string, record: T): Observable<Response> {
		const url = this.baseUrl + "/" + entityCode;
		return this.httpClient.put<Response>(url, record);
	}  	
	
	delete(entityCode: string, id: number): Observable<any> {
		const url = this.baseUrl + "/" + entityCode + "/" + id;
		return this.httpClient.delete(url);
	}  	
}
