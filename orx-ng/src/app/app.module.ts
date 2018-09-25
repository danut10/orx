import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './components/app/app.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AppRoutingModule } from './app-routing.module';
import { ContentComponent } from './components/content/content.component';
import { RoleListComponent } from './components/role-list/role-list.component';

@NgModule({
  
  declarations: [
    AppComponent,
    UserDetailsComponent,
    UserListComponent,
    HeaderComponent,
    FooterComponent,
    ContentComponent,
    RoleListComponent
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
	//
}
