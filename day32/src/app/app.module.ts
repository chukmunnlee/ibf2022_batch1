import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { RegistrationComponent } from './components/registration.component';
import { TodoComponent } from './components/todo.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    TodoComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
