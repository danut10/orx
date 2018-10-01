import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { User } from '../../domain/user';
import { DataRecord } from '../../domain/dataRecord';
import { UserService } from '../../services/user.service';
import { GenericService } from '../../services/generic.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

	screenMode: string;
	screenTitle: string;
	currentRecord: User;
	recordList: User[];	
	
	constructor(
		private userService: UserService,
		private genericService: GenericService,
		private route: ActivatedRoute		
	) { }

	ngOnInit() {
		this.genericService.readList<User>()
			.subscribe(list => this.recordList = list);
		
		//const id = +this.route.snapshot.params["id"];
		this.screenMode = 'list';
		this.screenTitle = 'Users';
	}

}
