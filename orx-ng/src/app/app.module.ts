import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './components/app/app.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UserListComponent } from './components/user-list/user-list.component';

@NgModule({
  
  declarations: [
    AppComponent,
    UserDetailsComponent,
    UserListComponent
  ],
  
  imports: [
    BrowserModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
