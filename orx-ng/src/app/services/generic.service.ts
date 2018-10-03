import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserFilter, Pager } from '../domain/userFilter';

import { DataRecord } from '../domain/dataRecord';

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

	readFilter<T extends DataRecord>(entityCode: string, filter: UserFilter): Observable<T[]> {
		const url = this.baseUrl + "/" + entityCode + "/filter";
		return this.httpClient.post<T[]>(url, filter);
	}  
	
	browse<T extends DataRecord>(entityCode: string, filter: UserFilter, sorter: Sorter, pager: Pager): Observable<T[]> {
		
		let url = `${this.baseUrl}/${entityCode}/browse`;
		if (sorter && sorter.field) { url += ";sorterField=" + sorter.field; }
		if (sorter && sorter.desc) { url += ";sorterDesc=" + true; }
		if (pager && pager.pageSize) { url += ";pageSize=" + pager.pageSize; }
		if (pager && pager.pageNo) { url += ";pageNo=" + pager.pageNo; }
		
		// const url = `${this.baseUrl}/${entityCode}/browse;pageSize=${pager.pageSize};pageNo=${pager.pageNo};sorterField=${sorter.field};sorterDesc=${sorter.desc}` 
		// const url = this.baseUrl + "/" + entityCode + "/filter/" + pager.pageSize + "/" + pager.pageNo + ";s=vasile" ;
		return this.httpClient.post<T[]>(url, filter);
	}  
	
	// Methods - Command
	
	
}
