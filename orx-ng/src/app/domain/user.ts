import { DataRecord } from './core';

export class User implements DataRecord {
	id: number;
	name: string;
	emailAddress: string;
	password: string;
}

export class UserFilter {
	name: string;
	emailAddress: string;
}
