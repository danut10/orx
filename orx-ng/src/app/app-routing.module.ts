import { UserDetailsComponent } from "./components/user-details/user-details.component";
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserListComponent } from './components/user-list/user-list.component';

const routes: Routes = [
	{ path: 'user-list', component: UserListComponent }, 
	{ path: 'user-details', component: UserDetailsComponent }
];	

@NgModule({
	imports: [ RouterModule.forRoot(routes) ],
	exports: [ RouterModule ]
})
export class AppRoutingModule { 
	// do nothing
}
