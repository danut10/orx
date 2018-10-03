import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './components/user/user.component';
import { RoleComponent } from './components/role/role.component';


const routes: Routes = [
	{ path: 'users/:mode', component: UserComponent } 
	, { path: 'roles/:mode', component: RoleComponent } 
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
