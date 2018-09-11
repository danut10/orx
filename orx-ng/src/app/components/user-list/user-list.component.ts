import { Component, OnInit } from '@angular/core';
import { User, userList } from '../../domain/user';


@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

	constructor() { }

	ngOnInit() {
	}
	
	currentRecord: User;
	recordList = userList;	

	select(user: User): void {
		this.currentRecord = user;
	}	
}
