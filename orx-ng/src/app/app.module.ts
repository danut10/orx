import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app/app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ContentComponent } from './components/content/content.component';

import { UserListComponent } from './components/user-list/user-list.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
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
    BrowserModule
    , HttpClientModule
    , AppRoutingModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
	//
}
