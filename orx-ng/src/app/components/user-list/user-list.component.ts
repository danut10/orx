import { Component, OnInit } from '@angular/core';

import { User } from '../../domain/user';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

	currentRecord: User;
	recordList: User[];	

	constructor(
		private userService: UserService
		) { }

	ngOnInit() {
		this.userService.readList()
			.subscribe(list => this.recordList = list);
	}
	
	/*
	 * Custom methods
	 */

	select(user: User): void {
		this.currentRecord = user;
	}	
}
