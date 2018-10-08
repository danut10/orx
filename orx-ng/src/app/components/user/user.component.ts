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
	screenTitle: string = "Users";
	entityCode: string = "user";
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
		const id = +this.route.snapshot.params["id"];
		this.screenMode = mode;
		
		if (mode == "list") { 
			//this.filter.name = "Dan Maxim";
			this.pager.pageNo = 1;
			this.sorter.field = "name";
			//this.sorter.desc = true;
			this.genericService.browse<User>("user", this.filter, this.sorter, this.pager)
				.subscribe(list => this.recordList = list);
		} else if (mode == "view" || mode == "edit") { 
			this.genericService.read<User>("user", id)
				.subscribe(record => this.record = record);		
		} else if (mode == "add") { 
			this.record = new User(); 
		}
	}
	
	/*
	 * Methods - action
	 */ 
	
	private delete(id: number) {
		this.genericService.delete("user", id)
			.subscribe(() => this.router.navigate(["/users/list"]));
	}
		
	private save() {
		if (this.screenMode == "edit") {
			let id = this.record.id;
			this.genericService.update("user", this.record)
				.subscribe(() => this.router.navigate(["/users/view", { id:id }]));
		}
		if (this.screenMode == "add") {
			this.genericService.create("user", this.record)
				.subscribe((id) => this.router.navigate(["/users/view", { id:id }]));
		}
	}

	private cancel() {
		let id = this.record.id;
		this.router.navigate(["/users/view", { id:id }]);		
	}	
	
}
