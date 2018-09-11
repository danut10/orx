import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './components/app/app.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';

@NgModule({
  
  declarations: [
    AppComponent,
    UserDetailsComponent
  ],
  
  imports: [
    BrowserModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
