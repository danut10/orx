export interface DataRecord {
	id: number;
}

export class Pager {
	constructor() {
		let sorter: Sorter;
		sorter = new Sorter();
	}
	
	recordCount: number;
	pageSize: number;
	pageNo: number;
	
	
}

export class Sorter { 
	field: string;
	desc: boolean;
}



