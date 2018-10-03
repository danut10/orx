import { DataRecord } from './dataRecord';

export class UserFilter extends DataRecord {
	emailAddress: string;
	name: string;
	
}

export class Pager {
	recordCount: number;
	pageSize: number;
	pageNo: number;
}

export class Sorter {
	field: string;
	desc: boolean;
}
