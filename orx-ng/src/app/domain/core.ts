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

export class ScreenMode {
	name: string;
	
	constructor(name: string) {
		this.name = name;
	}
	
	isList() : boolean { return (this.name == "list"); }
	isDetails() : boolean { return (this.name == "view" || this.name == "edit" || this.name == "add"); }

	isEditable() : boolean { return (this.name == "add" || this.name == "edit"); }
	isRecord() : boolean { return (this.name == "view" || this.name == "edit"); }

	isView() : boolean { return (this.name == "view"); }
	isEdit() : boolean { return (this.name == "edit"); }
	isAdd() : boolean { return (this.name == "add"); }
}



