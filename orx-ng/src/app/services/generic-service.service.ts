import { Injectable } from '@angular/core';

import { DataRecord } from '../domain/dataRecord';

@Injectable({
  providedIn: 'root'
})
export class GenericServiceService<T extends DataRecord> {

  constructor() { }
}
