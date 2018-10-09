import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";

import { Pager, Sorter, ScreenMode } from '../../domain/core';
import { GenericService } from '../../services/generic.service';
import { User, UserFilter } from '../../domain/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

	screenMode: ScreenMode;
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
		this.screenMode = new ScreenMode(mode);
		
		if (this.screenMode.isList()) { 
			//this.filter.name = "Dan Maxim";
			this.pager.pageNo = 1;
			this.sorter.field = "name";
			//this.sorter.desc = true;
			this.genericService.browse<User>("user", this.filter, this.sorter, this.pager)
				.subscribe(list => this.recordList = list);
		} else if (this.screenMode.isRecord()) { 
			this.genericService.read<User>("user", id)
				.subscribe(record => this.record = record);		
		} else if (this.screenMode.isAdd) { 
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
		
	private save(doEdit: boolean) {
		let url: string = (doEdit ? "/users/edit" : "users/view"); 
		if (this.screenMode.isEdit()) {
			let id = this.record.id;
			this.genericService.update("user", this.record)
				.subscribe(() => this.router.navigate([url, { id:id }]));
		} else if (this.screenMode.isAdd) {
			this.genericService.create("user", this.record)
				.subscribe((id) => this.router.navigate([url, { id:id }]));
		}
	}

	private cancel() {
		if (this.screenMode.isEdit()) {
			let id = this.record.id;
			this.router.navigate(["/users/view", { id:id }]);		
		} else if (this.screenMode.isAdd()) {
			this.router.navigate(["/users/list"]);		
		}		
	}	
	
}
