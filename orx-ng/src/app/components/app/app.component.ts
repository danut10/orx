import { Component } from '@angular/core';
import * as $ from 'jquery';
import 'metismenu';

// declare let $: any;

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'Open RobotX - User Interface';
	
	ngAfterViewInit() {
		//
		$('#menu').metisMenu();
		
	}	

}
