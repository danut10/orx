import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './components/app/app.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  
  declarations: [
    AppComponent,
    UserDetailsComponent,
    UserListComponent,
    HeaderComponent,
    FooterComponent
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
