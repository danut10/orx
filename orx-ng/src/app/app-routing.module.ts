import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserListComponent } from './components/user-list/user-list.component';
import { RoleListComponent } from './components/role-list/role-list.component';


const routes: Routes = [
	  { path: 'user-list', component: UserListComponent }
	, { path: 'role-list', component: RoleListComponent } 
	// { outlet: 'primary1', path: 'user-list', component: UserListComponent }, 
	//{ outlet: 'primary1', path: 'user-details/:id', component: UserDetailsComponent }
];	

@NgModule({
	imports: [ RouterModule.forRoot(routes) ],
	exports: [ RouterModule ]
})
export class AppRoutingModule { 
	// do nothing
}
