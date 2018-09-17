import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
	constructor(private route: ActivatedRoute) { }

	ngOnInit() {
		const id = +this.route.snapshot.params["id"];	  
	}

}
