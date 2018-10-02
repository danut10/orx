import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";

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
	record: User;
	recordList: User[];	
	
	constructor(
		private userService: UserService,
		private genericService: GenericService,
		private route: ActivatedRoute,
		private router: Router		
		) {
			 
		this.router.routeReuseStrategy.shouldReuseRoute = (() => false );
	}

	ngOnInit() {
		//let qryParams = this.route.snapshot.queryParams;
		//let mode = qryParams["mode"];
		//let id = qryParams["id"];
		//const id = +this.route.snapshot.params["id"];
		
		const mode = this.route.snapshot.params["mode"];
		
		
		this.screenTitle = 'Users';
		this.screenMode = mode;
		
		if (mode == "list") {
			this.genericService.readList<User>()
				.subscribe(list => this.recordList = list);
		}

		if (mode == "view") {
			const id = +this.route.snapshot.params["id"];
			this.genericService.read<User>(id)
				.subscribe(record => this.record = record);
		}
		
	}

}
