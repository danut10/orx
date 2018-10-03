import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";

import { Pager, Sorter } from '../../domain/core';
import { GenericService } from '../../services/generic.service';
import { User, UserFilter } from '../../domain/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

	screenMode: string;
	screenTitle: string;
	filter: UserFilter = new UserFilter;
	pager: Pager = new Pager();
	sorter = new Sorter();
	record: User = new User;
	recordList: User[];	
	
	
	constructor(
		private genericService: GenericService,
		private route: ActivatedRoute,
		private router: Router		
		) {
		this.router.routeReuseStrategy.shouldReuseRoute = (() => false );
	}

	ngOnInit() {
		const mode = this.route.snapshot.params["mode"];

		this.screenTitle = "Users";
		this.screenMode = mode;
		
		if (mode == "list") {
			//this.filter.name = "Dan Maxim";
			this.pager.pageNo = 1;
			this.sorter.field = "name";
			//this.sorter.desc = true;
			
			this.genericService.browse<User>("user", this.filter, this.sorter, this.pager)
				.subscribe(list => this.recordList = list);
			
		}

		if (mode == "view") {
			const id = +this.route.snapshot.params["id"];
			this.genericService.read<User>("user", id)
				.subscribe(record => this.record = record);
		}
		
	}

}
