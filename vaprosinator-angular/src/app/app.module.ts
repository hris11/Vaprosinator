import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AuthHandlerComponent } from './auth-handler/auth-handler.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthHandlerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
