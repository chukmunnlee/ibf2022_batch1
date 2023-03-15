import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { AddItemComponent } from './components/add-item.component';
import { ListItemsComponent } from './components/list-items.component';
import { UserInfoComponent } from './components/user-info.component';

@NgModule({
  declarations: [
    AppComponent,
    AddItemComponent,
    ListItemsComponent,
    UserInfoComponent
  ],
  imports: [
    BrowserModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
